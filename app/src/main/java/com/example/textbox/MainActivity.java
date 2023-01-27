package com.example.textbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final  String FILE_NAME = "Example.txt";
    Button btncreate, btnopen, btnsave;
    EditText txtinp;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncreate=findViewById(R.id.btn_create);
        btncreate.setOnClickListener(this);
        btnopen=findViewById(R.id.btn_open);
        btnopen.setOnClickListener(this);
        btnsave=findViewById(R.id.btn_save);
        btnsave.setOnClickListener(this);
        txtinp=findViewById(R.id.txt_inp);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(btncreate)) {
            String text=txtinp.getText().toString();
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());

            txtinp.setText(" ");
            Toast.makeText(this, "File Saved  "+ getFilesDir().getName()+ " "+FILE_NAME, Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(fos!=null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(v.equals(btnsave)) {
            String text=txtinp.getText().toString();
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());

                txtinp.setText(" ");
                Toast.makeText(this, "File Saved"+ getFilesDir().getName()+FILE_NAME, Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(fos!=null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(v.equals(btnopen)) {
            FileInputStream fis = null;
            try {
                fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();

                String text;

                while ((text = br.readLine()) != null){
                      sb.append(text +"\n");
                }
                txtinp.setText(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fis!=null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        }
}