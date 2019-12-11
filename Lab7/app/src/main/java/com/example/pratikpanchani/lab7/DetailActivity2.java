package com.example.pratikpanchani.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Intent intent = getIntent();
        String stringData =intent.getStringExtra("itemname2");
        textView = findViewById(R.id.txt_view11);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemdept2");
        textView = findViewById(R.id.txt_view22);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemyear2");
        textView = findViewById(R.id.txt_view33);
        textView.setText(stringData);
    }
}
