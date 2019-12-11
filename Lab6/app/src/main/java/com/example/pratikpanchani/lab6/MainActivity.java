package com.example.pratikpanchani.lab6;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    SQLiteDatabase sqLiteDatabase1;
    EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase1 = openOrCreateDatabase("IDNameGrade", Context.MODE_PRIVATE, null);
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS IDNameGrade(ID VARCHAR, Name VARCHAR, GRADE VARCHAR);");

        editText1 = findViewById(R.id.edit_id);
        editText2 = findViewById(R.id.edit_name);
        editText3 = findViewById(R.id.edit_grade);

        button1 = findViewById(R.id.add_button);
        button2 = findViewById(R.id.view_button);
        button3 = findViewById(R.id.find_button);
        button4 = findViewById(R.id.del_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO IDNameGrade VALUES('"+ editText1.getText() +
                        "','"+editText2.getText() + "','"+editText3.getText()+"');");
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("The following student was added");
                alertDialog.setMessage("ID:" + editText1.getText()+ " Name:" + editText2.getText()+ " Grade:" + editText3.getText());
                alertDialog.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });

        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer All = new StringBuffer();
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade",null);
                String temp = "No student records";

                while(cursorSelectAll.moveToNext()) {
                    All.append("ID:" + cursorSelectAll.getString(0) + " Name: " +
                            cursorSelectAll.getString(1) + " Grade: "
                    + cursorSelectAll.getString(2) + ".\n");
                    temp = "The following students have been added";

                }


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(temp);
                alertDialog.setMessage(All);

                alertDialog.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        }));

        button3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer All = new StringBuffer();
                String temp = "These student does not exists";
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade WHERE ID = '" + editText1.getText()+"';",null);

                while(cursorSelectAll.moveToNext()) {
                    All.append("ID:" + cursorSelectAll.getString(0) + " Name: " +
                            cursorSelectAll.getString(1) + " Grade: "
                            + cursorSelectAll.getString(2) + ".\n");
                    temp = "The student detail are as follows";
                }


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(temp);
                alertDialog.setMessage(All);

                alertDialog.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        }));

        button4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer All = new StringBuffer();
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade WHERE ID = '" + editText1.getText()+"';",null);
                String temp = "These student does not exists";

                while(cursorSelectAll.moveToNext()) {
                    All.append("ID:" + cursorSelectAll.getString(0) + " Name: " +
                            cursorSelectAll.getString(1) + " Grade: "
                            + cursorSelectAll.getString(2) + ".\n");
                    temp = "The following student is been deleted";
                }


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(temp);
                alertDialog.setMessage(All);

                alertDialog.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alertDialog.show();

                Cursor cursorSelectDelete = sqLiteDatabase1.rawQuery("DELETE FROM IDNameGrade WHERE ID = '" + editText1.getText()+"';",null);
                while(cursorSelectDelete.moveToNext()) {
                    All.append("ID:" + cursorSelectDelete.getString(0) + " Name: " +
                            cursorSelectDelete.getString(1) + " Grade: "
                            + cursorSelectDelete.getString(2) + ".\n");
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        }));

    }
}
