package com.rakibitfarm.sylhetcattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CowBeefMeasurementActivity extends AppCompatActivity {

    EditText editText;

    double dressingPercentage = 60.0;

    TextView textView;
    Button calculateBeefWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_beef_measurement);



        //===========
        getSupportActionBar().setTitle("মাংসের ওজন নির্ণয়");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================




        editText = findViewById(R.id.editext);
        textView  = findViewById(R.id.tvdispaly);

        calculateBeefWeight = findViewById(R.id.calculateBeefWeight);


        calculateBeefWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1 = editText.getText().toString();


                if(s1.equals(""))
                {
                    Toast.makeText(CowBeefMeasurementActivity.this,"গরুর ওজন কত তা দেন ", Toast.LENGTH_SHORT).show();
                }

                else{

                    editText.setText("");
                    float cowWeight  = Float.parseFloat(s1);
                    float weightOfBeef = (float) (cowWeight * (dressingPercentage/100.0));

                    textView.setText("The weight of beef obtained from the cow is " +weightOfBeef + " kg");
                }



            }
        });




    }



    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(CowBeefMeasurementActivity.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++







    public void onBackPressed()
    {
        Intent intent = new Intent(CowBeefMeasurementActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}