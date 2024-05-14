package com.example.myapplication.slot30;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Slot301MainActivity extends AppCompatActivity {
    Context context=this;
    private ListView listView;
    private ArrayList<Photo> photos = new ArrayList<>();
    private ArrayList<Photo> cartItems = new ArrayList<>();
    private ArrayAdapter<Photo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot301_main);

        listView = findViewById(R.id.slot301Lv);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, photos);
        listView.setAdapter(adapter);

        fetchDataFromServer();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Photo photo = photos.get(position);
                addToCart(photo);
                navigateToCartActivity(); // Add this line to navigate to CartActivity after adding item to cart
            }
        });
    }

    private void fetchDataFromServer() {
        // Replace URL with your server URL
        new FetchDataTask().execute("https://jsonplaceholder.typicode.com/albums/1/photos");
    }

    private void addToCart(Photo photo) {
        cartItems.add(photo);
        // Add your logic for adding photo to cart here
        Toast.makeText(this, "Added to cart: " + photo.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private class FetchDataTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String result = null;

            try {
                URL url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder buffer = new StringBuilder();
                if (inputStream == null) {
                    return null;
                }

                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                if (buffer.length() == 0) {
                    return null;
                }
                result = buffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String url = jsonObject.getString("url");
                        String thumbnailUrl = jsonObject.getString("thumbnailUrl");
                        Photo photo = new Photo(title, url, thumbnailUrl);
                        photos.add(photo);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    //-----------cart
    void navigateToCartActivity() {
        Intent intent = new Intent(Slot301MainActivity.this, Slot301CartActivity.class);
        // Truyền dữ liệu giỏ hàng dưới dạng ArrayList thông thường
        intent.putParcelableArrayListExtra("cartItems", cartItems);
        startActivity(intent);
    }
    //-----------
}