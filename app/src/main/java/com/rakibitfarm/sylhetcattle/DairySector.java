package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

public class DairySector extends AppCompatActivity {


    TabLayout tabLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_sector);


        //===========
        getSupportActionBar().setTitle("ডেইরি সেক্টর");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================




        tabLayout = findViewById(R.id.tabLayout);

        tabLayout = findViewById(R.id.tabLayout);

        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout,new MilkFramFragment());
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int tabPosition = tab.getPosition();

                if(tabPosition == 0)
                {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.framelayout,new MilkFramFragment());
                    fragmentTransaction.commit();

                }

                if(tabPosition == 1)
                {
                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.framelayout,new GaviSellFragment());
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(DairySector.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++


    public void onBackPressed()
    {
        Intent intent = new Intent(DairySector.this,MainActivity.class);
        startActivity(intent);
        finish();
    }




}