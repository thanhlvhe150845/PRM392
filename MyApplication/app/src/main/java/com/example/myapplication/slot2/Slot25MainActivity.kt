package com.example.myapplication.slot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class Slot25MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot23_main)
        var tv1=findViewById<TextView>(R.id.slot2A23Tv1)
        val i1=intent
        val chuoi1=i1.extras!!.getString("a")
        val chuoi2=i1.extras!!.getString("b")
        val so1=chuoi1!!.toFloat()
        val so2=chuoi2!!.toFloat()
        val sum=so1+so2
        tv1!!.text=sum.toString()
    }
}