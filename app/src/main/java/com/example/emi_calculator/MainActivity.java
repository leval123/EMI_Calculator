package com.example.emi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   // declare variables for the widgets
    EditText mortgage , tenure, interest_rate;
    TextView EMI;
    Button calculate;
    // declare variables for calculations
    double results , pow;
    double  m,t,ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set variables to match widgets ids
        EMI = (TextView) findViewById(R.id.EMI);
        mortgage = (EditText) findViewById(R.id.mortgage);
        interest_rate = (EditText) findViewById(R.id.interest_rate);
        tenure = (EditText) findViewById(R.id.tenure);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //takes the input from the app and stores it as a double
                m = Double.parseDouble(mortgage.getText().toString());
                t = Double.parseDouble(tenure.getText().toString());
                ir = Double.parseDouble(interest_rate.getText().toString());

                //using the RMI formula calculate EMI
                pow = Math.pow((1+((ir/100)/12)),(t*12));
                results = m * ((ir/100)/12) * (pow/(pow-1));

                // takes the calculated EMI and outputs to 2 decimal places using Math.round()
                EMI.setText(String.valueOf(Math.round(results * 100.0) / 100.0));

            }
        });




    }
}