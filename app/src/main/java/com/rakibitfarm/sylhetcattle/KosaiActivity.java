package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class KosaiActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;



    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosai);


        //===========
        getSupportActionBar().setTitle("কসাই সার্ভিস");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================


        progressBar = findViewById(R.id.progressBarId);
        listView = findViewById(R.id.listViewId);


        String url = "https://rakibalam.000webhostapp.com/apps/myfolder/kosaiSeviceView.php";

        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                progressBar.setVisibility(View.GONE);

                try {

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String image_link = jsonObject.getString("image");
                        String name = jsonObject.getString("kosai_name");
                        String address = jsonObject.getString("kosai_address");


                        hashMap = new HashMap<>();
                        hashMap.put("id", id);
                        hashMap.put("image", image_link);
                        hashMap.put("kosai_name", name);
                        hashMap.put("kosai_address", address);


                        arrayList.add(hashMap);


                    }

                    MyAdapter myAdapter = new MyAdapter();
                    listView.setAdapter(myAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "NO INTERNET!! Try these steps to get back online:   " +
                        "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();


                progressBar.setVisibility(View.GONE);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(KosaiActivity.this);
        requestQueue.add(jsonArrayRequest);





    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.kosaisample_view,viewGroup,false);

            ImageView imageView = myView.findViewById(R.id.imageViewId);
            TextView kosainame = myView.findViewById(R.id.kosaiNameId);
            TextView kosaiaddress = myView.findViewById(R.id.kosaiAddressId);



            HashMap<String, String> hashMap = arrayList.get(position);
            String tvid = hashMap.get("id");
            String image_link = hashMap.get("image");
            String name = hashMap.get("kosai_name");
            String address = hashMap.get("kosai_address");


            kosainame.setText("কসাইয়ের নাম: "+name);
            kosaiaddress.setText("লোকেশন: "+address);



            Picasso.get()
                    .load("https://rakibalam.000webhostapp.com/apps/myfolder/Images/" + image_link)
                    .into(imageView);


            return myView;
        }
    }

    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(KosaiActivity.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++





    public void onBackPressed()
    {
        Intent intent = new Intent(KosaiActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}