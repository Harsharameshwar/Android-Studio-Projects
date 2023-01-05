package com.example.weatherapp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;



import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;

import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1;
    ImageView i1,i2;
    TextView t1;
   FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
i1=findViewById(R.id.idIVSearch);
e1=findViewById(R.id.idEdtCity);
i2=findViewById(R.id.idIVIcon);
t1=findViewById(R.id.idTVTemperature);
i1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String cityname = e1.getText().toString();
        try {

            URL u = new URL("http://api.weatherapi.com/v1/current.json?key=8534db2f73f8490bba2182721230501&q="+cityname+"&aqi=no");
            HttpURLConnection htp = (HttpURLConnection) u.openConnection();
            htp.setRequestMethod("GET");
            htp.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int httpResponse = htp.getResponseCode();
            System.out.println("httpResponse: " + httpResponse);
            BufferedReader in = new BufferedReader(new InputStreamReader(htp.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            JSONObject jsonObject = new JSONObject(response.toString());
            t1.setText(jsonObject.getJSONObject("current").get("temp_c").toString()+" °C");
          String imageUrl = "https:"+jsonObject.getJSONObject("current").getJSONObject("condition").get("icon").toString();
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
            i2.setImageBitmap(bitmap);
            i2.getLayoutParams().height=400;
            i2.getLayoutParams().width=500;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (ProtocolException protocolException) {
            protocolException.printStackTrace();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }


    }
});


    }


}