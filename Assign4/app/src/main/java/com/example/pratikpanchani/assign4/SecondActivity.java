package com.example.pratikpanchani.assign4;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    EditText city_editText, name_editText, mvp_editText, editTextID;
    Button exit2Button, addrow2Button, deleteButton, updateButton;
    TextView textView, textviewSpinner1;
    LinearLayout topLayout, bottomLayout;
    Spinner spinner1;
    ImageView image;
    String string1, imgDecodableString;
    Boolean bool_spinner = true;
    public static String stringDataName64;
    byte[] imageArray = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        city_editText = findViewById(R.id.e_city);
        name_editText = findViewById(R.id.e_name);
        editTextID = findViewById(R.id.textID);

        spinner1 = findViewById(R.id.s_sport);
        textviewSpinner1 = findViewById(R.id.textSpinner);
        bool_spinner = false;
        List<String> spinList = Arrays.asList(" ","Baseball","Basketball","Football","Hockey");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,spinList);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                string1 = parent.getItemAtPosition(position).toString();
                if(bool_spinner)
                {
                    textviewSpinner1.setText(string1);
                }
                bool_spinner = true;
                if(string1.length() > 2)
                {
                    textviewSpinner1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mvp_editText = findViewById(R.id.e_mvp);

        image = findViewById(R.id.image1);
        Button uploadimage_btn = findViewById(R.id.upload);
        uploadimage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(
                        Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,100);
            }
        });

        addrow2Button = findViewById(R.id.submit);
        addrow2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler databaseHandler2 = new DatabaseHandler(getApplicationContext());
                String item0 = city_editText.getText().toString();
                String item1 = name_editText.getText().toString();
                String item2 = string1;
                String item3 = mvp_editText.getText().toString();

                Bitmap bitmap2 = ((BitmapDrawable)image.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG,20,byteArrayOutputStream1);
                imageArray = byteArrayOutputStream1.toByteArray();
                String base64_string = Base64.encodeToString(imageArray, Base64.DEFAULT);

                if(item0.length() != 0){
                    databaseHandler2.insertItem(item0,item1,item2,item3, base64_string);
                    city_editText.setText("");
                    name_editText.setText("");
                    spinner1.setVisibility(View.VISIBLE);
                    spinner1.setSelection(0);
                    textviewSpinner1.setText("");
                    mvp_editText.setText("");
                    Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.notfound);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
                    imageArray = byteArrayOutputStream.toByteArray();
                    image.setImageBitmap(BitmapFactory.decodeByteArray(SecondActivity.this.imageArray, 0, SecondActivity.this.imageArray.length));
                }
            }
        });

        updateButton = findViewById(R.id.update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler update_DatabaseHandler = new DatabaseHandler(getApplicationContext());
                String itemID = editTextID.getText().toString();
                String item0 = city_editText.getText().toString();
                String item1 = name_editText.getText().toString();
                String item2 = string1;
                String item3 = mvp_editText.getText().toString();

                Bitmap bitmap2 = ((BitmapDrawable)image.getDrawable()).getBitmap();
                ByteArrayOutputStream update_byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG,20,update_byteArrayOutputStream);
                imageArray = update_byteArrayOutputStream.toByteArray();
                String base64String = Base64.encodeToString(imageArray, Base64.DEFAULT);
                if (itemID.length() > 0) {
                    update_DatabaseHandler.deleteItem(itemID);
                    update_DatabaseHandler.insertItem(item0, item1, item2, item3, base64String);
                    Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        deleteButton = findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler delete_DatabaseHandler = new DatabaseHandler(getApplicationContext());
                delete_DatabaseHandler.deleteItem(city_editText.getText().toString());
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        exit2Button = findViewById(R.id.exit);
        exit2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String stringData = intent.getStringExtra("itemname0");
        textView = findViewById(R.id.e_city);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemname1");
        textView = findViewById(R.id.e_name);
        textView.setText(stringData);
        stringData = intent.getStringExtra("itemname2");
        textviewSpinner1.setText(stringData);
        stringData = intent.getStringExtra("itemname3");
        textView = findViewById(R.id.e_mvp);
        textView.setText(stringData );
        stringData = intent.getStringExtra("itemname4");
        textView = findViewById(R.id.textID);
        textView.setText(stringData);
        stringData = intent.getStringExtra("command");
        topLayout = findViewById(R.id.top);
        bottomLayout = findViewById(R.id.bottom);

        if(stringData.equals("add")){
            deleteButton.setVisibility(View.GONE);
            updateButton.setVisibility(View.GONE);
            addrow2Button.setVisibility(View.VISIBLE);
            topLayout.setBackgroundColor(Color.parseColor("#00ff00"));
            bottomLayout.setBackgroundColor(Color.parseColor("#0000ff"));
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.notfound);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap1.compress(Bitmap.CompressFormat.PNG,20,byteArrayOutputStream);
            imageArray = byteArrayOutputStream.toByteArray();
            image.setImageBitmap(BitmapFactory.decodeByteArray(imageArray,0,imageArray.length));
        }
        if(stringData.equals("ud")){
            deleteButton.setVisibility(View.VISIBLE);
            updateButton.setVisibility(View.VISIBLE);
            addrow2Button.setVisibility(View.GONE);
            topLayout.setBackgroundColor(Color.parseColor("#ffa000"));
            bottomLayout.setBackgroundColor(Color.parseColor("#0000ff"));
            byte[] decodedString = Base64.decode(stringDataName64,Base64.DEFAULT);
            Bitmap bitmap64 = BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
            image.setImageBitmap(bitmap64);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            ImageView image1 = findViewById(R.id.image1);
            image1.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
        }
        catch (Exception e) { }
    }
}
