package com.example.inputboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.submit);
        e1=(EditText) findViewById(R.id.Email);
        e2=(EditText) findViewById(R.id.Password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                System.out.println(email+password);
                Toast.makeText(getApplicationContext(),email+" "+ password,Toast.LENGTH_LONG).show();
                if(email.equals("admin") && password.equals("admin")){
                    Bundle b= new Bundle();
                    b.putString("e",email);
                    Intent i=new Intent(MainActivity.this,Home.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong User",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

