package com.rakibitfarm.sylhetcattle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        cardView1 = findViewById(R.id.cardView1Id);
        cardView2 = findViewById(R.id.cardView2Id);
        cardView3 = findViewById(R.id.cardView3Id);
        cardView4 = findViewById(R.id.cardView4Id);
        cardView5 = findViewById(R.id.cardView5Id);
        cardView6 = findViewById(R.id.cardView6Id);
        cardView7 = findViewById(R.id.cardView7Id);
        cardView8 = findViewById(R.id.cardView8Id);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CowGoatBuySellActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CowWeightCalculator.class);
                startActivity(intent);
                finish();

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CowBeefMeasurementActivity.class);
                startActivity(intent);
                finish();

            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,CowBazarUpdateAndNoticeActivity.class);
                startActivity(intent);
                finish();


            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,CowFeedActivity.class);
                startActivity(intent);
                finish();


            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,DairySector.class);
                startActivity(intent);
                finish();

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,KosaiActivity.class);
                startActivity(intent);
                finish();

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,TruckServiceActivity.class);
                startActivity(intent);
                finish();

            }
        });




    }
}