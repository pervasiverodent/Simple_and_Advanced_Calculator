package com.java.calculatorabat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redirectPage();
    }

    public void redirectPage() {
        Button simpleCalculator, advancedCalculator;

        simpleCalculator = findViewById(R.id.simple_calculator_button);
        advancedCalculator = findViewById(R.id.advanced_calculator_button);

        simpleCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SimpleCalculator.class);
                startActivity(intent);
            }
        });

        advancedCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdvancedCalculator.class);
                startActivity(intent);
            }
        });
    }


}
