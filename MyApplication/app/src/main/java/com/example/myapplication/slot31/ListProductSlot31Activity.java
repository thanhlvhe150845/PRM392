package com.example.myapplication.slot31;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListProductSlot31Activity extends AppCompatActivity {
    private ListView listView;
    private ProductSlot31Adapter adapter;
    private List<ProductSlot31> productList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_slot31);
        listView = findViewById(R.id.slot31A310Lv1);
        productList = new ArrayList<>();
        adapter = new ProductSlot31Adapter(this, productList);
        listView.setAdapter(adapter);

        // Lấy dữ liệu từ server
        new FetchProductsTask().execute();
    }
    private class FetchProductsTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new
                        URL("https://hungnttg.github.io/shopgiay.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new
                        BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null && !result.isEmpty()) {
                try {
                    JSONObject json = new JSONObject(result);
                    JSONArray productsArray = json.getJSONArray("products");
                    for (int i = 0; i < productsArray.length(); i++) {
                        JSONObject productObject =
                                productsArray.getJSONObject(i);
                        String styleId = productObject
                                .getString("styleid");
                        String brand = productObject
                                .getString("brands_filter_facet");
                        String price = productObject.getString("price");
                        String additionalInfo = productObject
                                .getString("product_additional_info");
                        String searchImage = productObject
                                .getString("search_image");
                        ProductSlot31 product = new
                                ProductSlot31(styleId, brand, price,
                                additionalInfo, searchImage);
                        productList.add(product);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(ListProductSlot31Activity.this,
                        "Failed to fetch products!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}