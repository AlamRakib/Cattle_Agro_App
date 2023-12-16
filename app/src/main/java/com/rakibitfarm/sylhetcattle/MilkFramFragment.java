package com.rakibitfarm.sylhetcattle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
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
import java.util.Random;


public class MilkFramFragment extends Fragment {

    ProgressBar progressBar;
    ListView listView;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View myView = inflater.inflate(R.layout.fragment_milk_fram, container, false);

        if(container!=null)
        {
            container.removeAllViews();
        }




        progressBar = myView.findViewById(R.id.progressBarId);
        listView = myView.findViewById(R.id.listViewId);


        String url = "https://rakibalam.000webhostapp.com/apps/myfolder/milkentryview.php";

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
                        String farmname = jsonObject.getString("name");
                        String ownermobile = jsonObject.getString("mobile");
                        String ownerlocation = jsonObject.getString("location");



                        hashMap = new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("name",farmname);
                        hashMap.put("mobile",ownermobile);
                        hashMap.put("location",ownerlocation);


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


                Toast.makeText(getContext(), "NO INTERNET!! Try these steps to get back online:   " +
                        "1.Check your mobile data and router       or         2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();

                progressBar.setVisibility(View.GONE);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);





        return myView;
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
            View myview = layoutInflater.inflate(R.layout.sample_view4, viewGroup, false);


            TextView name = myview.findViewById(R.id.t1);
            TextView mobile = myview.findViewById(R.id.t2);
            TextView location = myview.findViewById(R.id.t3);


            HashMap<String, String> hashMap = arrayList.get(position);
            String id = hashMap.get("id");
            String agroName = hashMap.get("name");
            String number = hashMap.get("mobile");
            String place = hashMap.get("location");


            name.setText(agroName);
            mobile.setText("মোবাইল নাম্বার: "+number);
            location.setText("লোকেশন: "+place);




            return myview;
        }



    }









}