package com.example.myapplication.slot6;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Demo6MainActivity extends AppCompatActivity {
 EditText txtMa,txtTen,txtSL;
 Button btnLoad,btnThem,btnSua,btnXoa;
 ListView lv;
 SanPhamDAO sanPhamDAO;
 ArrayAdapter<String> arrayAdapter;
 List<String> ds=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo6_main);
      txtMa=findViewById(R.id.demo61TxtMaSP);
      txtTen=findViewById(R.id.demo61TxtTenSP);
      txtSL=findViewById(R.id.demo61TxtSLSP);
      btnLoad=findViewById(R.id.demo6BtnLoad);
      btnThem=findViewById(R.id.demo6BtnAdd);
      btnSua=findViewById(R.id.demo6BtnUpdate);
      btnXoa=findViewById(R.id.demo6BtnDelete);
      lv=findViewById(R.id.demo61Lv);
      sanPhamDAO=new SanPhamDAO(this);

      btnThem.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SanPham s=new SanPham();
              s.setMasp(txtMa.getText().toString());
              s.setTensp(txtTen.getText().toString());
              s.setSoLuongSP(Integer.parseInt(txtSL.getText().toString()));
              int kq=sanPhamDAO.insertProduct(s);
              if(kq==-1){
                  Toast.makeText(getApplicationContext(),
                          "Insert that bai",Toast.LENGTH_LONG).show();
              }
              if(kq==1){
                  Toast.makeText(getApplicationContext(),
                          "Insert thanh cong",Toast.LENGTH_LONG).show();
              }
          }
      });
      btnXoa.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
              int kq=sanPhamDAO.deleteProduct(txtMa.getText().toString());
              if(kq==-1){
                  Toast.makeText(getApplicationContext(),
                          "Xoa that bai",Toast.LENGTH_LONG).show();
              }
              if(kq==1){
                  Toast.makeText(getApplicationContext(),
                          "Xoa thanh cong",Toast.LENGTH_LONG).show();
              }
          }
      });
      btnSua.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SanPham s=new SanPham();
              s.setMasp(txtMa.getText().toString());
              s.setTensp(txtTen.getText().toString());
              s.setSoLuongSP(Integer.parseInt(txtSL.getText().toString()));
              int kq=sanPhamDAO.updateProduct(s);
              if(kq==-1){
                  Toast.makeText(getApplicationContext(),
                          "Sua that bai",Toast.LENGTH_LONG).show();
              }
              if(kq==1){
                  Toast.makeText(getApplicationContext(),
                          "Sua thanh cong",Toast.LENGTH_LONG).show();
              }
          }
      });
      btnLoad.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ds.clear();
              ds=sanPhamDAO.getAllProductToString();
              arrayAdapter=new ArrayAdapter<>(Demo6MainActivity.this, android.R.layout.simple_list_item_1,ds);
              lv.setAdapter(arrayAdapter);

          }
      });
    }
}