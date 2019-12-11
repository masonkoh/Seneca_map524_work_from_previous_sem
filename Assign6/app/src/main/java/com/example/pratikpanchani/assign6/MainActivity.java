package com.example.pratikpanchani.assign6;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Spinner spinner;
    TextView textDate;
    Button dateButton, submit;
    String spinnerSelected = "magnitude";
    final int datePicker = 0;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.num);
        spinner = findViewById(R.id.spin);
        textDate = findViewById(R.id.date_text);
        dateButton = findViewById(R.id.date_button);
        submit = findViewById(R.id.submit);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year + "-" + (month+1) + "-" + day);
        textDate.setText(stringBuilder.toString());

        spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList(new String[]{"magnitude", "date"})));

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialog(0);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinnerSelected = "magnitude";
                    return;
                }
                spinnerSelected = "time";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("order", spinnerSelected);
               // intent.putExtra("limit", textDate.getText().toString());
                intent.putExtra("magnitude", editText1.getText().toString());
                intent.putExtra("start", textDate.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case datePicker:
                return new DatePickerDialog(this, pickerListener, year, month, day);
        }
        return null;
    }

    DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int yearPar, int monthPar, int dayPar) {
            year = yearPar;
            month = monthPar;
            day = dayPar;
            textDate.setText(year + "-" + (month + 1) + "-" + day);
        }
    };
}


