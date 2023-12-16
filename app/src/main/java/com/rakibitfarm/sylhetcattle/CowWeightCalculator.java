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

public class CowWeightCalculator extends AppCompatActivity {

    EditText editText1, editText2;
    Button calculateButton;
    double conversionFactor = 2.20462;
    TextView tvdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_weight_calculator);


        //===========
        getSupportActionBar().setTitle("গরুর ওজন নির্ণয় ");
        //===============



        //=======================+Action BAr=================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //===================================================





        editText1 = findViewById(R.id.editext1);
        editText2 = findViewById(R.id.edittext2);

        calculateButton = findViewById(R.id.calculateButton);
        tvdisplay = findViewById(R.id.tvdispaly);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = editText1.getText().toString();
                String s2 = editText2.getText().toString();



                if(s1.equals("") )
                {
                    Toast.makeText(CowWeightCalculator.this,"গরুর দৈর্ঘ্য কত তা দেন", Toast.LENGTH_SHORT).show();
                }
                else if (s2.equals(""))
                {
                    Toast.makeText(CowWeightCalculator.this,"গরুর বেড় কত তা দেন", Toast.LENGTH_SHORT).show();

                }
                else
                {


                    float length  = Float.parseFloat(s1);
                    float girth  = Float.parseFloat(s2);


                    float weight = (float) (length * girth * girth) / 660;
                    {
                        editText1.setText("");
                        editText2.setText("");
                        tvdisplay.setText("The weight of the cow is : " + weight + " kg");
                    }

                }



            }
        });




    }


    //++++++++++++++++++++++++Action BAr Back Button+++++++++++++++++

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== android.R.id.home)
        {

            Intent myIntent = new Intent(CowWeightCalculator.this,MainActivity.class);
            startActivity(myIntent);

        }

        return super.onOptionsItemSelected(item);
    }
    //++++++++++++++++++++++++Action BAr Back Button End +++++++++++++++++






    public void onBackPressed()
    {
        Intent intent = new Intent(CowWeightCalculator.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}