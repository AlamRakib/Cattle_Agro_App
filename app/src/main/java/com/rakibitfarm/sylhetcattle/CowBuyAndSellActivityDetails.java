package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CowBuyAndSellActivityDetails extends AppCompatActivity {

    ImageView imageView;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;


    public static String COWNAME = "";
    public static String COWCLASS = "";
    public static String COWWEIGHT = "";
    public static String FARMNAME = "";
    public static String FARMQWNERNAME = "";
    public static String FARMOWNERNUMBER = "";
    public static String COWGENDER = "";
    public static String COWPRICE = "";


 
    public static Bitmap MyBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_buy_and_sell_details);



        //===========
        getSupportActionBar().setTitle("ডিটেইলস");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================





        imageView = findViewById(R.id.imageViewId);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);





        t1.setText(COWNAME);
        t2.setText(COWCLASS);
        t3.setText(COWWEIGHT + " কেজি");
        t4.setText(FARMNAME);
        t5.setText(FARMQWNERNAME);
        t6.setText(FARMOWNERNUMBER);
        t7.setText(COWGENDER);
        t8.setText(COWPRICE+"/=");


        if(MyBitmap!=null)
        {
            imageView.setImageBitmap(MyBitmap);
        }



    }




    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(CowBuyAndSellActivityDetails.this,CowGoatBuySellActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++




    public void onBackPressed()
    {
        Intent intent = new Intent(CowBuyAndSellActivityDetails.this,CowGoatBuySellActivity.class);
        startActivity(intent);
        finish();
    }

}