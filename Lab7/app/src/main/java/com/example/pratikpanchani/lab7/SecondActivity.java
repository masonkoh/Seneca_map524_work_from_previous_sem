package com.example.pratikpanchani.lab7;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String[] itemname;
    String[] itemdept;
    String[] itemyear;

    String[] itemname2;
    String[] itemdept2;
    String[] itemyear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        itemname = intent.getStringArrayExtra("stringName");
        itemdept = intent.getStringArrayExtra("stringDept");
        itemyear = intent.getStringArrayExtra("stringYear");
        itemname2 = intent.getStringArrayExtra("stringName2");
        itemdept2 = intent.getStringArrayExtra("stringDept2");
        itemyear2 = intent.getStringArrayExtra("stringYear2");

        CustomListAdapter1 adapter1 = new CustomListAdapter1(this, itemname);
        CustomListAdapter2 adapter2 = new CustomListAdapter2(this, itemname2);


        ListView listView1 = findViewById(R.id.list_view1);
        ListView listView2 = findViewById(R.id.list_view2);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemname[i] != null) {
                    Intent intent = new Intent
                            (SecondActivity.this, DetailActivity.class);
                    intent.putExtra("itemname", itemname[i]);
                    intent.putExtra("itemdept", itemdept[i]);
                    intent.putExtra("itemyear", itemyear[i].toString());
                    startActivity(intent);
                }
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemname2[i] != null) {
                    Intent intent = new Intent
                            (SecondActivity.this, DetailActivity2.class);
                    intent.putExtra("itemname2", itemname2[i]);
                    intent.putExtra("itemdept2", itemdept2[i]);
                    intent.putExtra("itemyear2", itemyear2[i].toString());
                    startActivity(intent);
                }
            }
        });

    }
}

class CustomListAdapter1 extends ArrayAdapter<String> {
    private Activity context;
    private String[] name;

    CustomListAdapter1(Activity context, String[] name_1) {
        super(context, R.layout.textviewitem, name_1);
        this.context = context;
        this.name = name_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitem, null, true);
        TextView tvName = rowView.findViewById(R.id.text_view);
        tvName.setText(name[position]);
        return rowView;
    }
}

class CustomListAdapter2 extends ArrayAdapter<String> {
    private Activity context;
    private String[] name;

    CustomListAdapter2(Activity context, String[] name_1) {
        super(context, R.layout.textviewitem2, name_1);
        this.context = context;
        this.name = name_1;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.textviewitem2, null, true);
        TextView tvName = rowView.findViewById(R.id.text_view2);
        tvName.setText(name[position]);
        return rowView;
    }
}

