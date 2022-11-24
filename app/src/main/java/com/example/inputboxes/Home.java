package com.example.inputboxes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends Activity {
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Bundle b= getIntent().getExtras();
        String name= b.getString("e");
        t1=(TextView)findViewById(R.id.textView);
        t1.setText("Welcome "+name);
    }
}
