package com.example.myapplication.slot2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot23MainActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot23_main);
        tv1=findViewById(R.id.slot2A23Tv1);
        //receive data
        Intent i1=getIntent();
        //extract data package
        double a= Double.parseDouble(i1.getExtras().getString("a"));
        double b= Double.parseDouble(i1.getExtras().getString("b"));
        //sum
        double sum=a+b;
        //put data to screen
        tv1.setText(String.valueOf(sum));
    }
}