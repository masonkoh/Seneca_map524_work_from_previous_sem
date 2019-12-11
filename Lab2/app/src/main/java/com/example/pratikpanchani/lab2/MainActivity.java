package com.example.pratikpanchani.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = findViewById(R.id.editText1);
                button1.setText(user.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pass = findViewById(R.id.editText2);
                button2.setText(pass.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = findViewById(R.id.editText1);
                EditText pass = findViewById(R.id.editText2);
                button3.setText(user.getText().toString() + "-" + pass.getText().toString());
            }

        });
    }
}
