package com.example.pratikpanchani.lab5;

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

public class MainActivity extends AppCompatActivity {

    String[] arrayAlphabet1 = {"avacado","carbohydrates","celery","citrus","cucumber","naturalfood","nocelery","soy",
            "vegansymbol","bacon","apple"};
    Integer[] imgId1 = {R.drawable.avacado,R.drawable.carbohydrates,R.drawable.celery,
                        R.drawable.citrus,R.drawable.cucumber,
                        R.drawable.naturalfood,R.drawable.nocelery,R.drawable.soy,
                        R.drawable.vegansymbol,R.drawable.bacon,R.drawable.apple};
    String[] arrayAlphabet2 = {"fructose","hazelnut","kiwi","leek","mushroom","organicfood","pear","peas",
            "raspberry","vegetarianmark","frenchfries"};
    Integer[] imgId2 = {R.drawable.fructose,R.drawable.hazelnut,R.drawable.kiwi,
                        R.drawable.leek,R.drawable.mushroom,
                        R.drawable.organicfood,R.drawable.pear,R.drawable.peas,
                        R.drawable.raspberry,R.drawable.vegetarianmark,R.drawable.frenchfries};
    String[] arrayAlphabet3 = {"A","B","C","D","E","F","G","H",
            "I","J","K"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = findViewById(R.id.list_view1);
        ListView listView2 = findViewById(R.id.list_view2);

        CustomListAdapter1 adapter1 = new CustomListAdapter1(this,arrayAlphabet1,imgId1);
        listView1.setAdapter(adapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent
                        (MainActivity.this,DetailActivity.class);
                intent.putExtra("itemname",arrayAlphabet1[i]);
                intent.putExtra("imgid",imgId1[i].toString());
                startActivity(intent);
            }
        });

        CustomListAdapter2 adapter2 = new CustomListAdapter2(this,arrayAlphabet2,imgId2,arrayAlphabet3);
        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent
                        (MainActivity.this,DetailActivity2.class);
                intent.putExtra("itemname",arrayAlphabet2[i]);
                intent.putExtra("imgid",imgId2[i].toString());
                intent.putExtra("itemname2",arrayAlphabet3[i]);
                startActivity(intent);
            }
        });
    }
}

    class CustomListAdapter1 extends ArrayAdapter<String>{
        private Activity context;
        private String[] name;
        private Integer[] image;

        CustomListAdapter1(Activity context, String[] name_1, Integer[] image_1){
            super(context,R.layout.textviewitem,name_1);
            this.context = context;
            this.image = image_1;
            this.name = name_1;
        }

        public @NonNull
        View getView(int position, View view, @NonNull ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.textviewitem,null, true);
            TextView tvName = rowView.findViewById(R.id.text_view);
            ImageView imageView = rowView.findViewById(R.id.image_view);
            tvName.setText(name[position]);
            imageView.setImageResource(image[position]);
            return rowView;
        }
    }

class CustomListAdapter2 extends ArrayAdapter<String>{
    private Activity context;
    private String[] name;
    private Integer[] image;
    private String[] name2;

    CustomListAdapter2(Activity context, String[] name_1, Integer[] image_1,String[] name_2){
        super(context,R.layout.textviewitem2,name_1);
        this.context = context;
        this.name = name_1;
        this.image = image_1;
        this.name2 = name_2;
    }

    public @NonNull
    View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.textviewitem2, null, true);

        TextView tvName = rowView.findViewById(R.id.text_view11);
        ImageView imageView = rowView.findViewById(R.id.image_view11);
        TextView tvName2 = rowView.findViewById(R.id.text_view12);

        tvName.setText(name[position]);
        imageView.setImageResource(image[position]);
        tvName2.setText(name2[position]);

        return rowView;
    }
}
