package com.example.myapplication.slot3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Demo34MainActivity extends AppCompatActivity {
    TextView tvKQ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo34_main);
        tvKQ=findViewById(R.id.demo34TvKQ);
        //get data from intent
        Intent intent1=getIntent();
        //extract data
        int a= Integer.parseInt(intent1.getExtras().getString("hsa"));
        int b=Integer.parseInt(intent1.getExtras().getString("hsb"));
        int c=Integer.parseInt(intent1.getExtras().getString("hsc"));
        //delta=?
        int delta=b*b-4*a*c;
        if(delta<0){
            tvKQ.setText("PTVN");
        }
        else if(delta==0){
            tvKQ.setText("PT co nghiem kep x="+ (-b)/(2*a));
        }
        else {
            float x1= (float) ((-b+Math.sqrt(delta))/(2*a));
            float x2= (float) ((-b-Math.sqrt(delta))/(2*a));
            tvKQ.setText("PT co 2 nghiem x1="+x1+" va x2="+x2);
        }
    }
}