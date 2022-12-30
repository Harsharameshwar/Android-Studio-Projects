package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtname,txtid,txtage,txtaddress;
    Button btnsubmit,btnsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtid=findViewById(R.id.txt_id);
        txtname=findViewById(R.id.txt_name);
        txtage=findViewById(R.id.txt_age);
        txtaddress=findViewById(R.id.txt_add);
        btnsearch=findViewById(R.id.txt_move);
        btnsearch.setOnClickListener(this);
        btnsubmit=findViewById(R.id.txt_sub);
        btnsubmit.setOnClickListener(this);
    }

    public void onClick( View view) {
        if(view.equals(btnsubmit)){
            String eid=txtid.getText().toString();
            String ename=txtname.getText().toString();
            String eage=txtage.getText().toString();
            String eaddress=txtaddress.getText().toString();
            MyDatabase data=new MyDatabase(this, MyDatabase.DATABASE_NAME, null, 1);
            SQLiteDatabase db=data.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("id",eid);
            cv.put("name",ename);
            cv.put("age",eage);
            cv.put("address",eaddress);
            db.insert("Employee", null,cv); db.close();
            Toast.makeText(this, "Successfully inserted to database ", Toast.LENGTH_SHORT).show();

        }
        else if(view.equals(btnsearch)){
            Intent it=new Intent(this,SearchActivity.class);
            startActivity(it);
        }
    }
}