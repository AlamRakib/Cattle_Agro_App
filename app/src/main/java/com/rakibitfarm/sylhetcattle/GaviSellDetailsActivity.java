package com.rakibitfarm.sylhetcattle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GaviSellDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView t1,t2,t3,t4,t5,t6,t7;


    public static String COWCLASS = "";
    public static String COWMILK = "";
    public static String COWWEIGHT = "";
    public static String FARMNAME = "";
    public static String FARMQWNERNAME = "";
    public static String FARMOWNERNUMBER = "";
    public static String COWPRICE = "";

    public static Bitmap MyBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gavi_sell_details);

        imageView = findViewById(R.id.imageViewId);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);

        t1.setText("জাত:  " +COWCLASS);
        t2.setText("দুধ উৎপাদন ক্ষমতা:   " +COWMILK + " লিটার দৈনিক");
        t3.setText("গরুর ওজন:  " +COWWEIGHT + " কেজি");
        t4.setText("খামারের নাম:  " +FARMNAME);
        t5.setText("খামার মালিকের নাম:  " +FARMQWNERNAME);
        t6.setText("খামার মালিকের নাম্বার:  " +FARMOWNERNUMBER);
        t7.setText("দাম:  " +COWPRICE);


        if(MyBitmap!=null)
        {
            imageView.setImageBitmap(MyBitmap);
        }


    }
}