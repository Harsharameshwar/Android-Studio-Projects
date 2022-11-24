package com.example.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.add);
        e1= findViewById(R.id.n1);
        e2=findViewById(R.id.n2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = e1.getText().toString();
                String n2 = e2.getText().toString();
                int num1,num2,result;
                num1=Integer.valueOf(n1);
                num2=Integer.valueOf(n2);
                result=(num1+num2);
                t1=findViewById(R.id.res1);
                t1.setText(""+result);
                System.out.println(result)  ;
            }
        });
    }
}