package com.example.myapplication.slot5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Demo51MainActivity extends AppCompatActivity {
    ListView listView;
    Demo51Adapter adapter;
    List<Demo51Product> list=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo51_main);
        listView=findViewById(R.id.demo51Listview1);
        //Demo51SqliteHelper helper=new Demo51SqliteHelper(this);
        //SQLiteDatabase db=helper.getReadableDatabase();
        Demo51ProductDAO dao=new Demo51ProductDAO(this);
//        Demo51Product p=new Demo51Product("3","San pham 3",234,1);
//        int kq=dao.insertProduct(p);
        list=dao.getAll();
        adapter=new Demo51Adapter(list,this);
        listView.setAdapter(adapter);
        //int kq=dao.insertProduct(p);

    }
}