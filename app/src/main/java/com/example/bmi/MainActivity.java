package com.example.bmi;


import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("You need to enter your weight in order to calculate your BMI");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("You need to enter your height in order to calculate your BMI");
                    e2.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;


                float bmiValue = udregnBMI(weight, height);


                String bmiInterpretation = BMItf(bmiValue);

                tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }


    private float udregnBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }


    private String BMItf(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";

        } else if (bmiValue < 18.5) {
            return "Skinny Legend";

        } else if (bmiValue < 25) {

            return "Normal";

        } else if (bmiValue < 30) {
            return "You fat fuck";

        } else {
            return "You have officially been submitted to fat camp";
        }
    }
}
