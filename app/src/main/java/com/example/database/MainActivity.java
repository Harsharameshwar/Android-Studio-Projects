package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,id,address,age;
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.txt_name);
        age=findViewById(R.id.txt_age);
        address=findViewById(R.id.txt_add);
        id=findViewById(R.id.txt_id);

        b1= findViewById(R.id.txt_sub);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String id1=id.getText().toString();
                String address1=address.getText().toString();
                String age1=age.getText().toString();

                MyDatabase data=new MyDatabase(getApplicationContext(),MyDatabase.DATABSASE_NAME,null,1);
                SQLiteDatabase db= data.getWritableDatabase();
                ContentValues cv= new ContentValues();
                cv.put("name",name1);
                cv.put("age",age1);
                cv.put("id",id1);
                cv.put("address",address1);
                db.insert("Employee",null,cv);
                db.close();
                Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_LONG).show();
            }
        });

        b2=findViewById(R.id.txt_move);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(it);
            }
        });

    }
}