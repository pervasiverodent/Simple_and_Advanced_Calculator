package com.java.calculatorabat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedCalculator extends AppCompatActivity {

    public static final String TAG = "AdvancedCalculator";
    TextView inputValue;

    Button buttonSeven, buttonEight, buttonNine, buttonMode; //First row
    Button buttonFour, buttonFive, buttonSix, buttonMean; //Second row
    Button buttonOne, buttonTwo, buttonThree, buttonMedian; //Third Row
    Button buttonDot, buttonZero, buttonEqual, buttonComma; //Fourth Row
    Button buttonDelete, buttonErase; //Fifth Row

    private boolean isMode, isMean, isMedian = false;
    private boolean hasDot, hasComma = false;

    private String valueOne, valueTwo, textValue;

    private Double inputOne, inputTwo, inputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);
        initializeFields();
        listenForButtonInput();
    }

    private void initializeFields() {
        inputValue = findViewById(R.id.input_value);

        buttonSeven = findViewById(R.id.button_7);
        buttonEight = findViewById(R.id.button_8);
        buttonNine = findViewById(R.id.button_9);
        buttonMode = findViewById(R.id.button_mode);

        buttonFour = findViewById(R.id.button_4);
        buttonFive = findViewById(R.id.button_5);
        buttonSix = findViewById(R.id.button_6);
        buttonMean = findViewById(R.id.button_mean);

        buttonOne = findViewById(R.id.button_1);
        buttonTwo = findViewById(R.id.button_2);
        buttonThree = findViewById(R.id.button_3);
        buttonMedian = findViewById(R.id.button_median);

        buttonDot = findViewById(R.id.button_dot);
        buttonZero = findViewById(R.id.button_0);
        buttonEqual = findViewById(R.id.button_equals);
        buttonComma = findViewById(R.id.button_comma);

        buttonDelete = findViewById(R.id.button_delete);
        buttonErase = findViewById(R.id.button_erase);
    }

    private void listenForButtonInput() {

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "0");
            }
        });

        buttonMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isMode = true;
                isMean = false;
                isMedian = false;

                hasDot = false;
                hasComma = false;

                computeMode();
            }
        });

        buttonMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isMode = false;
                isMean = true;
                isMedian = false;

                hasDot = false;
                hasComma = false;
            }
        });

        buttonMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isMode = false;
                isMean = false;
                isMedian = true;

                hasDot = false;
                hasComma = false;
            }
        });

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hasComma) {
                    int length = inputValue.getText().toString().length();
                    if(length != 0) {
                        inputValue.setText((inputValue.getText().toString()) + "," + "");
                    } else {
                        inputValue.setText(0 + "," + "");
                    }
                    //hasComma = true;
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(inputValue.getText().toString().isEmpty()) && inputValue.getText().toString() != null) {
                    computeValues();
                } else {
                    inputValue.setText("");
                }

            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hasDot) {
                    int length = inputValue.getText().toString().length();
                    if(length != 0) {
                        inputValue.setText((inputValue.getText().toString()) + "." + "");
                    } else {
                        inputValue.setText(0 + "." + "");
                    }

                    hasDot = true;
                }
            }
        });



        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputValue.getText().equals("")) {
                    inputValue.setText("");
                } else {
                    int length = inputValue.getText().length();

                    if(inputValue.getText().toString().charAt(length - 1) == '.') {
                        hasDot = false;
                        hasComma = false;
                        inputValue.setText(inputValue.getText().subSequence(0, length - 1));
                    } else {
                        inputValue.setText("");
                    }
                }
            }
        });

        buttonErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eraseValues();
            }
        });

        inputValue.setLongClickable(false); // This is to prevent on click and copy/paste within input box.
        inputValue.setTextIsSelectable(false);
    }



    public int mode() {
        int value = Integer.parseInt(inputValue.getText().toString());
        int[] sequence = new int[value];

        int maxValue = 0;
        int maxCount = 0;

        for(int i = 1; i < sequence.length; ++i) {
            int count = 0;
            for (int j = 0; j < sequence.length; ++j) {
                if(sequence[j] == sequence[i]) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = sequence[i];
            }
        }

        return maxValue;
    }

    public void computeValues() {

        if(inputValue.getText().toString().isEmpty()) { // Treat as no value or null
            inputValue.setText("" + mode());
        } else {
            inputResult = 0.0;

            valueTwo = inputValue.getText().toString();
            inputOne = Double.parseDouble(valueOne);
            inputTwo = Double.parseDouble(valueTwo);
            inputValue.setText(null);

            if (isMode) {
                computeMode();
            } else if (isMean) {
                //computeMean();
            } else if (isMedian) {
                //computeMedian();
            } else {
//                Toast.makeText(this, "Something happened.", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "Compute Values | Input Value ELSE: " + inputValue.toString());
//                debugValues();
            }
        }
    }

    private void computeMode() {
        valueOne = inputValue.getText().toString();
        String[] valueArray = textValue.split(",");

        List<String> fixedList = Arrays.asList(valueArray);
        ArrayList<String> listOfNumbers = new ArrayList<String>(fixedList);

        Log.d(TAG, "List: " + listOfNumbers);
        System.out.println("List: " + textValue);
        System.out.println("List: " + listOfNumbers);
        System.out.println("List: " + listOfNumbers.size());

    }

    private void computeMean() {

    }

    private void computeMedian() {

    }



    private void eraseValues() {
        inputOne = null;
        inputTwo = null;
        valueOne = null;
        valueTwo = null;
        hasDot = false;
        hasComma = false;
        inputValue.setText("");
    }

    public void debugValues() {
        Log.d(TAG, "------------------");
        Log.d(TAG, "from debugValues()");
        Log.d(TAG, "Value One: " + valueOne);
        Log.d(TAG, "Value Two: " + valueTwo);
        Log.d(TAG, "Input One: " + inputOne);
        Log.d(TAG, "Input Two: " + inputTwo);
    }


}
