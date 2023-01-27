package com.example.jsonparse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button b1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.btn_parse);
        t1=findViewById(R.id.parse);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is= getAssets().open("example.json");
                    int size= is.available();
                    byte[] buffer= new byte[size];
                    is.read(buffer);
                    is.close();
                    String json= new String(buffer,"UTF-8");
                    JSONArray obj= new JSONArray(json);
                    t1.setText("");
                    for(int i=0;i<obj.length();i++){
                        JSONObject ob1= obj.getJSONObject(i);
                        String s1=ob1.getString("name");
                        String s2=ob1.getString("latitude");
                        String s3= ob1.getString("longitude");
                        String s4= ob1.getString("temperature");
                        t1.setText(t1.getText()+"Name"+s1+" Latitude"+s2+" Longitude"+s3+" Temperature"+s4+"\n");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}