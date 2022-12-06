package com.example.counterapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity implements OnClickListener, Runnable {
    int i=0;
    TextView txtcount;
    Button btnstart,btnstop;
    Thread thread;
    boolean running=false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.start);
        btnstop=(Button)findViewById(R.id.stop);
        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        txtcount=(TextView)findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method
        if(v.equals(btnstart))
        {
            running=true;
            thread=new
                    Thread(this);
            thread.start();
        }
        else if(v.equals(btnstop))
        {   //thread.interrupt();
            running=false;
        }
    }
    Handler hand;

    {
        hand = new Handler() {
            public void handleMessage(Message m) {
                txtcount.setText("" + m.what);
            }
        };
    }

    @Override
    public void run() {
// TODO Auto-generated method stub
//int i=0;
        while(i<100 && running)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
// TODO Auto-generated catch
                System.out.println(e);
            }
            hand.sendEmptyMessage(i);
            i++;
        }
    }
}


