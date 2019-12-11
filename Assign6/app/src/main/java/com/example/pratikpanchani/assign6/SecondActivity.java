package com.example.pratikpanchani.assign6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    ListView list;
    List<String> returnArray;
    String stringURL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=7&starttime=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String rec1 = intent.getStringExtra("order");
        String rec2 = intent.getStringExtra("start");
        String rec3 = intent.getStringExtra("magnitude");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringURL + rec2 + "&limit=" + rec3 + "&orderby=" + rec1);
        this.stringURL = stringBuilder.toString();
        new QuakeAsyncTask().execute(new String[]{this.stringURL});
    }

    class QuakeAsyncTask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... stringurl) {
            returnArray = Utils.fetchEarthquakeData(stringurl[0]);
            return returnArray;
        }

        public void onPostExecute(List<String> postExecuteResult){
            CustomListAdapter arrayAdapter = new CustomListAdapter(SecondActivity.this, postExecuteResult);
            list = findViewById(R.id.list1);
            list.setAdapter(arrayAdapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView currentURL = (TextView) view.findViewById(R.id.date3);
                    TextView currentLng = (TextView) view.findViewById(R.id.lng);
                    String stringLat = ((TextView) view.findViewById(R.id.lat)).getText().toString();
                    String stringLng = currentLng.getText().toString();

                    StringBuilder URLstring = new StringBuilder();
                    URLstring.append("https://www.openstreetmap.org/?mlat=" + stringLng + "&mlon=" + stringLat + "#map=5/" + stringLng + "/" + stringLat);
                    Intent intent = new Intent
                            ("android.intent.action.VIEW", Uri.parse(URLstring.toString()));
                    startActivity(intent);
                }
            });
        }
    }

    class CustomListAdapter extends ArrayAdapter<String> {
        Activity context;
        List<String> itemname1;

        public CustomListAdapter(Activity activity, List<String> itemnameA){
            super(activity,R.layout.one_quake,itemnameA);
            this.context = activity;
            this.itemname1 = itemnameA;
        }

        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.one_quake,null,true);
            String earthInfo[] = itemname1.get(position).split("@@");
            TextView textInfo = rowView.findViewById(R.id.date);
            textInfo.setText(earthInfo[0]);
            Double magDouble = Double.valueOf(Double.parseDouble(earthInfo[5]));
            if (magDouble.doubleValue() <= 6.0d) {
                textInfo.setBackgroundColor(Color.parseColor("#00ff00"));
            }
            if (magDouble.doubleValue() >= 7.5d) {
                textInfo.setBackgroundColor(Color.parseColor("#ff0000"));
            }
            textInfo = (TextView) rowView.findViewById(R.id.date2);
            textInfo.setText(new Date(Long.parseLong(earthInfo[1])).toString());
            if (magDouble.doubleValue() <= 6.0d) {
                textInfo.setBackgroundColor(Color.parseColor("#00ff00"));
            }
            if (magDouble.doubleValue() >= 7.5d) {
                textInfo.setBackgroundColor(Color.parseColor("#ff0000"));
            }

            ((TextView) rowView.findViewById(R.id.date3)).setText(earthInfo[2]);
            ((TextView) rowView.findViewById(R.id.lat)).setText(earthInfo[3]);
            ((TextView) rowView.findViewById(R.id.lng)).setText(earthInfo[4]);
            ((TextView) rowView.findViewById(R.id.mag)).setText(earthInfo[5]);
            return rowView;
        }
    }


}
