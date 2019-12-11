
package com.example.pratikpanchani.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {
    TextView textView,textView1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Intent intent = getIntent();
        String stringData = intent.getStringExtra("itemname");
        textView = findViewById(R.id.txt_view2);
        textView.setText(stringData);

        stringData = intent.getStringExtra("imgid");
        Integer imageValue = new Integer(stringData);
        imageView = findViewById(R.id.img_view2);
        imageView.setImageResource(imageValue);

        String stringData1 = intent.getStringExtra("itemname2");
        textView1 = findViewById(R.id.txt_view3);
        textView1.setText(stringData1);
    }

}
