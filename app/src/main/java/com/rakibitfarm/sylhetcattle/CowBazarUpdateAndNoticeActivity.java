package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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



public class CowBazarUpdateAndNoticeActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;



    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_bazar_update_and_notice);


        //===========
        getSupportActionBar().setTitle("গরুর বাজারের আপডেট ও নোটিশ");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================






        progressBar = findViewById(R.id.progressBarId);
        listView = findViewById(R.id.listViewId);

        String url = "https://rakibalam.000webhostapp.com/apps/myfolder/CowBazarView.php";

        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                progressBar.setVisibility(View.GONE);

                try {

                    for(int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String image_link = jsonObject.getString( "image");
                        String description = jsonObject.getString( "description");



                        hashMap = new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("image",image_link);
                        hashMap.put("description",description);


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




            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(CowBazarUpdateAndNoticeActivity.this);
        requestQueue.add(jsonArrayRequest);


    }


    private class MyAdapter extends BaseAdapter {

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
            View myview = layoutInflater.inflate(R.layout.sample_view2, viewGroup, false);

            ImageView imageView = myview.findViewById(R.id.imageview);
            TextView description = myview.findViewById(R.id.description);

            HashMap<String, String> hashMap = arrayList.get(position);
            String tvid = hashMap.get("id");
            String image_link = hashMap.get("image");
            String des = hashMap.get("description");



            description.setText(des);




            Picasso.get()
                    .load("https://rakibalam.000webhostapp.com/apps/myfolder/Images/"+image_link)
                    .placeholder(R.drawable.cow)
                    .into(imageView);



            return myview;


        }
    }


    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(CowBazarUpdateAndNoticeActivity.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++







    public void onBackPressed()
    {
        Intent intent = new Intent(CowBazarUpdateAndNoticeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }




}