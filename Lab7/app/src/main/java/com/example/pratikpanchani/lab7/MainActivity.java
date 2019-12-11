package com.example.pratikpanchani.lab7;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonView ,buttonAdd2;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    String[] itemName = new String[50];
    String[] itemDept = new String[50];
    String[] itemYear = new String[50];
    String[] itemName2 = new String[50];
    String[] itemDept2 = new String[50];
    String[] itemYear2 = new String[50];
    SQLiteDatabase sqLiteDatabase1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase1 = openOrCreateDatabase("Lab7db", Context.MODE_PRIVATE,null);
       sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS namesTable(name VARCHAR, dept VARCHAR, year VARCHAR);");
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS namesTable2(name VARCHAR, dept VARCHAR, year VARCHAR);");

       editText1 = findViewById(R.id.edit_name1);
       editText2 = findViewById(R.id.edit_dept1);
       editText3 = findViewById(R.id.edit_year1);
       editText4 = findViewById(R.id.edit_name2);
       editText5 = findViewById(R.id.edit_dept2);
       editText6 = findViewById(R.id.edit_year2);
       buttonAdd = findViewById(R.id.add_button);
       buttonAdd2 = findViewById(R.id.add_button2);
       buttonView = findViewById(R.id.view_button);

       buttonAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sqLiteDatabase1.execSQL("INSERT INTO namesTable VALUES('"+editText1.getText() + "','"+ editText2.getText() + "','"+editText3.getText()+"');");
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
           }
       });

        buttonAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO namesTable2 VALUES('"+editText4.getText() + "','"+ editText5.getText() + "','"+editText6.getText()+"');");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
            }
        });

       buttonView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM namesTable",null);
               int counter = 0;
               while(cursorSelectAll.moveToNext())
               {
                   itemName[counter] = cursorSelectAll.getString(0);
                   itemDept[counter] = cursorSelectAll.getString(1);
                   itemYear[counter] = cursorSelectAll.getString(2);
                   counter+=1;
               }

               Cursor cursorSelectAll2 = sqLiteDatabase1.rawQuery("SELECT * FROM namesTable2",null);
               int counter2 = 0;
               while(cursorSelectAll2.moveToNext())
               {
                   itemName2[counter2] = cursorSelectAll2.getString(0);
                   itemDept2[counter2] = cursorSelectAll2.getString(1);
                   itemYear2[counter2] = cursorSelectAll2.getString(2);
                   counter2+=1;
               }

               Intent intent = new Intent(MainActivity.this,SecondActivity.class);
               intent.putExtra("stringName",itemName);
               intent.putExtra("stringDept",itemDept);
               intent.putExtra("stringYear",itemYear);
               intent.putExtra("stringName2",itemName2);
               intent.putExtra("stringDept2",itemDept2);
               intent.putExtra("stringYear2",itemYear2);
               startActivity(intent);
           }
       });

    }
}
