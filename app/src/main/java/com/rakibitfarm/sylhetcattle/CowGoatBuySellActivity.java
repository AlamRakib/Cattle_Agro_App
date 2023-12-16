package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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

public class CowGoatBuySellActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;



    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_goat_buy_sell);



        //===========
        getSupportActionBar().setTitle("গরু ছাগল বেচা কেনার পোস্ট");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================




        progressBar = findViewById(R.id.progressBarId);
        listView = findViewById(R.id.listViewId);

        String url = "https://rakibalam.000webhostapp.com/apps/myfolder/cowbuyselldataview.php";

        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                progressBar.setVisibility(View.GONE);


                try {

                    for(int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String image_link = jsonObject.getString( "image");
                        String cowname = jsonObject.getString( "cow_name");
                        String cowclass = jsonObject.getString( "cow_class");
                        String cowweight = jsonObject.getString( "cow_weight");
                        String agroname = jsonObject.getString( "agro_name");
                        String agroownername = jsonObject.getString( "agro_ownerName");
                        String agroownernuumber = jsonObject.getString( "agro_ownerNumber");
                        String cowgender = jsonObject.getString( "gender");
                        String cowprice = jsonObject.getString( "price");


                        hashMap = new HashMap<>();
                        hashMap.put("image",image_link);
                        hashMap.put("cow_name",cowname);
                        hashMap.put("cow_class",cowclass);
                        hashMap.put("cow_weight",cowweight);
                        hashMap.put("agro_name",agroname);
                        hashMap.put("agro_ownerName",agroownername);
                        hashMap.put("agro_ownerNumber",agroownernuumber);
                        hashMap.put("gender",cowgender);
                        hashMap.put("price",cowprice);

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


                Toast.makeText(CowGoatBuySellActivity.this, "NO INTERNET! Try these steps to get back online:   " +
                        "1.chcek your mobile data and routrer    or           2.Reconnect Wi-fi", Toast.LENGTH_LONG).show();


                progressBar.setVisibility(View.GONE);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(CowGoatBuySellActivity.this);
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
            View myview = layoutInflater.inflate(R.layout.sample_view, viewGroup, false);

            ImageView imageView = myview.findViewById(R.id.imageItemCoverId);
            TextView cowName = myview.findViewById(R.id.textView1);
            TextView cowClass = myview.findViewById(R.id.textView2);
            TextView cowweight = myview.findViewById(R.id.textView3);
            TextView cowfarmName = myview.findViewById(R.id.textView4);
            TextView cowFarmOwnerName = myview.findViewById(R.id.textView5);
            TextView cowFarmOwnerNumber = myview.findViewById(R.id.textView6);
            TextView cowgender = myview.findViewById(R.id.textView7);
            TextView cowprice = myview.findViewById(R.id.textView8);
            LinearLayout linearLayout = myview.findViewById(R.id.layIteam);



            HashMap<String, String> hashMap = arrayList.get(position);
            String image_link = hashMap.get("image");
            String goruname = hashMap.get("cow_name");
            String goruclass = hashMap.get("cow_class");
            String goruweight = hashMap.get("cow_weight");
            String goruagroname = hashMap.get("agro_name");
            String goruagroownername = hashMap.get("agro_ownerName");
            String goruagroownernumber = hashMap.get("agro_ownerNumber");
            String gorugender = hashMap.get("gender");
            String goruprice = hashMap.get("price");

            cowName.setText("গরুর নাম: "+goruname);
            cowClass.setText("জাত: "+goruclass);
            cowweight.setText("গরুর ওজন: "+goruweight + " কেজি");
            cowfarmName.setText("খামারের নাম: "+goruagroname);
            cowFarmOwnerName.setText("খামার মালিকের নাম: "+goruagroownername);
            cowFarmOwnerNumber.setText("খামার মালিকের নাম্বার: "+goruagroownernumber);
            cowgender.setText("লিঙ্গ: "+gorugender);
            cowprice.setText("দাম: "+goruprice + "/=");



            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    CowBuyAndSellActivityDetails.COWNAME = goruname;
                    CowBuyAndSellActivityDetails.COWCLASS = goruclass;
                    CowBuyAndSellActivityDetails.COWWEIGHT = goruweight;
                    CowBuyAndSellActivityDetails.FARMNAME = goruagroname;
                    CowBuyAndSellActivityDetails.FARMQWNERNAME = goruagroownername;
                    CowBuyAndSellActivityDetails.FARMOWNERNUMBER = goruagroownernumber;
                    CowBuyAndSellActivityDetails.COWGENDER = gorugender;
                    CowBuyAndSellActivityDetails.COWPRICE = goruprice;


                    Bitmap bitmap = ( (BitmapDrawable) imageView.getDrawable() ).getBitmap();
                    CowBuyAndSellActivityDetails.MyBitmap = bitmap;

                    Intent intent = new Intent(CowGoatBuySellActivity.this,CowBuyAndSellActivityDetails.class);
                    startActivity(intent);

                }
            });


            





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

            Intent myIntent = new Intent(CowGoatBuySellActivity.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++





    public void onBackPressed()
    {
        Intent intent = new Intent(CowGoatBuySellActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}