package com.example.pratikpanchani.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String stringData =intent.getStringExtra("itemname");
        textView = findViewById(R.id.txt_view1);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemdept");
        textView = findViewById(R.id.txt_view2);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemyear");
        textView = findViewById(R.id.txt_view3);
        textView.setText(stringData);
    }
}
