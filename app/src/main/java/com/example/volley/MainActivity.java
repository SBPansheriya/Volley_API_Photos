package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    Recyclerview_Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<Photos_Modal> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton  = findViewById(R.id.imagebutton);
        recyclerView = findViewById(R.id.recyclerview);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new Recyclerview_Adapter(MainActivity.this,list);
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        });


//     Volly in Android aevu Google par lakhiye aetle aave

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject mainobj = null;
                try {
                    JSONArray jsonArray = new JSONArray(response.toString());
                    for(int i=0; i<jsonArray.length(); i++){
                        mainobj = jsonArray.getJSONObject(i);
                        int id = mainobj.getInt("id");
                        int albumId = mainobj.getInt("albumId");
                        String title = mainobj. getString("title");
                        String url = mainobj. getString("url");
                        String thumbnailUrl = mainobj. getString("thumbnailUrl");
                        Photos_Modal photosModal = new Photos_Modal(id,albumId,title,url,thumbnailUrl);
                        list.add(photosModal);
                    }
                    Log.d("TTT ", "onResponse: "+list);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });
        queue.add(stringRequest);
    }
}