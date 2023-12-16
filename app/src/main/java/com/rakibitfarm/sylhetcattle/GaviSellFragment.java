package com.rakibitfarm.sylhetcattle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
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


public class GaviSellFragment extends Fragment {

    ProgressBar progressBar;
    ListView listView;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View myView = inflater.inflate(R.layout.fragment_gavi_sell, container, false);

        if(container!=null)
        {
            container.removeAllViews();


        }

        progressBar = myView.findViewById(R.id.progressBarId);
        listView = myView.findViewById(R.id.listViewId);



        String url = "https://rakibalam.000webhostapp.com/apps/myfolder/CowDairysectorView.php";

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
                        String cowclass = jsonObject.getString( "cow_class");
                        String cowmilk = jsonObject.getString( "cow_milk");
                        String cowweight = jsonObject.getString( "cow_weight");
                        String agroname = jsonObject.getString( "agro_name");
                        String agroownername = jsonObject.getString( "agro_ownerName");
                        String agroownernuumber = jsonObject.getString( "agro_ownerNumber");
                        String cowprice = jsonObject.getString( "cow_price");



                        hashMap = new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("image",image_link);
                        hashMap.put("cow_class",cowclass);
                        hashMap.put("cow_milk",cowmilk);
                        hashMap.put("cow_weight",cowweight);
                        hashMap.put("agro_name",agroname);
                        hashMap.put("agro_ownerName",agroownername);
                        hashMap.put("agro_ownerNumber",agroownernuumber);
                        hashMap.put("cow_price",cowprice);


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
            View myview = layoutInflater.inflate(R.layout.sample_view3, viewGroup, false);


            ImageView imageView = myview.findViewById(R.id.imageItemCoverId);
            TextView cowClass = myview.findViewById(R.id.textView1);
            TextView cowMilk = myview.findViewById(R.id.textView2);
            TextView cowweight = myview.findViewById(R.id.textView3);
            TextView cowfarmName = myview.findViewById(R.id.textView4);
            TextView cowFarmOwnerName = myview.findViewById(R.id.textView5);
            TextView cowFarmOwnerNumber = myview.findViewById(R.id.textView6);
            TextView cowprice = myview.findViewById(R.id.textView7);
            LinearLayout linearLayout = myview.findViewById(R.id.layIteam);



            HashMap<String, String> hashMap = arrayList.get(position);
            String id = hashMap.get("id");
            String image_link = hashMap.get("image");
            String goruclass = hashMap.get("cow_class");
            String gorumilk = hashMap.get("cow_milk");
            String goruweight = hashMap.get("cow_weight");
            String goruagroname = hashMap.get("agro_name");
            String goruagroownername = hashMap.get("agro_ownerName");
            String goruagroownernumber = hashMap.get("agro_ownerNumber");
            String goruprice = hashMap.get("cow_price");

            cowClass.setText("জাত: "+goruclass);
            cowMilk.setText("দুধ উৎপাদন ক্ষমতা: "+gorumilk + " লিটার দৈনিক");
            cowweight.setText("গরুর ওজন: "+goruweight + " কেজি");
            cowfarmName.setText("খামারের নাম: "+goruagroname);
            cowFarmOwnerName.setText("খামার মালিকের নাম: "+goruagroownername);
            cowFarmOwnerNumber.setText("খামার মালিকের নাম্বার: "+goruagroownernumber);
            cowprice.setText("দাম: "+goruprice);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    GaviSellDetailsActivity.COWCLASS = goruclass;
                    GaviSellDetailsActivity.COWMILK = gorumilk;
                    GaviSellDetailsActivity.COWWEIGHT = goruweight;
                    GaviSellDetailsActivity.FARMNAME = goruagroname;
                    GaviSellDetailsActivity.FARMQWNERNAME = goruagroownername;
                    GaviSellDetailsActivity.FARMOWNERNUMBER = goruagroownernumber;
                    GaviSellDetailsActivity.COWPRICE = goruprice;


                    Bitmap bitmap = ( (BitmapDrawable) imageView.getDrawable() ).getBitmap();
                    GaviSellDetailsActivity.MyBitmap = bitmap;


                    Intent intent = new Intent(getContext(),GaviSellDetailsActivity.class);
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
}