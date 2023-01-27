package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.lbl_number);
        t2=findViewById(R.id.lbl_message);
        Bundle b1= getIntent().getBundleExtra("data");

        if(b1!=null){
            String number= b1.getString("number");
            String content= b1.getString("content");
            t1.setText(number);
            t2.setText(content);
        }
    }
}