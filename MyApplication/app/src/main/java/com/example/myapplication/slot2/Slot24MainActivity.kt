package com.example.myapplication.slot2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class Slot24MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot22_main)
        var txt1=findViewById<EditText>(R.id.slot2A22Txt1)
        var txt2=findViewById<EditText>(R.id.slot2A22Txt2)
        var btn1=findViewById<Button>(R.id.slot2A22Btn1)
        btn1!!.setOnClickListener {
            var i=Intent(this@Slot24MainActivity,Slot25MainActivity::class.java)
            i.putExtra("a",txt1!!.text.toString())
            i.putExtra("b",txt2!!.text.toString())
            startActivity(i)
        }
    }
}