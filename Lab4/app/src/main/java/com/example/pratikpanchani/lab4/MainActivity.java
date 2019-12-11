package com.example.pratikpanchani.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] arrayAlphabet1 = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
    String[] arrayAlphabet2 = {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,
                R.layout.textviewitem,arrayAlphabet1);
        ListView listView1 = findViewById(R.id.list_view1);
        listView1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,
                R.layout.textviewitem2,arrayAlphabet2);
        ListView listView2 = findViewById(R.id.list_view2);
        listView2.setAdapter(arrayAdapter2);
    }
}
