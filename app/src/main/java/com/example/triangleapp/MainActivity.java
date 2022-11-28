package com.example.triangleapp;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        TextView answer = (TextView) findViewById(R.id.textView7);
        button.setOnClickListener((view) -> {
            String sidesStr = ((EditText) findViewById(R.id.inputValue)).getText().toString();
            String[] sides = sidesStr.split(",");
            if( sides.length==1 && sidesStr.equals("0")){
                answer.setText("The End");
                Toast.makeText(getApplicationContext(),"Bye Bye",Toast.LENGTH_LONG).show();
                return;
            }
            if (sides.length < 3) {
                answer.setText("Error: Must Enter 3 inputs");
                return;
            }
            if (sides.length > 3) {
                answer.setText("Error: Must Enter 3 inputs Only");
                return;
            }
            Double sideA = Double.parseDouble(sides[0]);
            Double sideB = Double.parseDouble(sides[1]);
            Double sideC = Double.parseDouble(sides[2]);
            Double s = (sideA + sideB + sideC) / 2;
            Double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

            if (sideA ==0 || sideB==0 || sideC==0){
                Log.d("Area", area.toString());
                answer.setText("Side should be greater then 0");
                return;
            }
            if (area <= 0) {
                Log.d("Area", area.toString());
                answer.setText("Invalid Triangle Sides");
                return;
            }
            if (sideA.equals(sideB) && sideB.equals(sideC))
                answer.setText("Equilateral Triangle");
            else if (sideA.equals(sideB) || sideB.equals(sideC) || sideC.equals(sideA))
                answer.setText("Isosceles Triangle");
            else
                answer.setText("Scalene Triangle");
        });
    }

}