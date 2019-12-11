package com.example.pratikpanchani.assign1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup1, radioGroup2, radioGroup3;
    Button button1, button2, button3;
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);

        radioGroup1.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.radioButton1)
                            Toast.makeText(getApplicationContext(), "Alice", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton2)
                            Toast.makeText(getApplicationContext(), "Bob", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton3)
                            Toast.makeText(getApplicationContext(), "Carol", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        button1 = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int changedRadio = radioGroup1.getCheckedRadioButtonId();
                if (changedRadio == R.id.radioButton1)
                    textView1.setText("Hi Alice");
                if (changedRadio == R.id.radioButton2)
                    textView1.setText("Hi Bob");
                if(changedRadio == R.id.radioButton3)
                    textView1.setText("Hi Carol");
            }
        });

        radioGroup2.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.radioButton4)
                            Toast.makeText(getApplicationContext(), "Dave", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton5)
                            Toast.makeText(getApplicationContext(), "Eve", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton6)
                            Toast.makeText(getApplicationContext(), "Fred", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int changedRadio = radioGroup2.getCheckedRadioButtonId();
                if (changedRadio == R.id.radioButton4)
                    textView2.setText("Hello Dave");
                if (changedRadio == R.id.radioButton5)
                    textView2.setText("Hello Eve");
                if(changedRadio == R.id.radioButton6)
                    textView2.setText("Hello Fred");
            }
        });

        radioGroup3.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.radioButton7)
                            Toast.makeText(getApplicationContext(), "Gina", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton8)
                            Toast.makeText(getApplicationContext(), "Henry", Toast.LENGTH_SHORT).show();
                        if(checkedId == R.id.radioButton9)
                            Toast.makeText(getApplicationContext(), "Ingrid", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        button3 = findViewById(R.id.button3);
        textView3 = findViewById(R.id.textView3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int changedRadio = radioGroup3.getCheckedRadioButtonId();
                if (changedRadio == R.id.radioButton7)
                    textView3.setText("Bonjour Gina");
                if (changedRadio == R.id.radioButton8)
                    textView3.setText("Bonjour Henry");
                if(changedRadio == R.id.radioButton9)
                    textView3.setText("Bonjour Ingrid");
            }
        });


    }
}
