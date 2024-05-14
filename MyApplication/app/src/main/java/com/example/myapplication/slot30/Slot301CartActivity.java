package com.example.myapplication.slot30;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Slot301CartActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Photo> cartItems = new ArrayList<>();
    private ArrayAdapter<Photo> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot301_cart);
        listView = findViewById(R.id.Slot31CartListview);
        // Lấy dữ liệu giỏ hàng từ Slot301MainActivity
        Intent intent=getIntent();
        cartItems = intent.getParcelableArrayListExtra("cartItems");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        listView.setAdapter(adapter);
    }
}