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
    Button buttonDot, buttonZero, buttonComma; //Fourth Row
    Button buttonDelete, buttonErase; //Fifth Row

    private boolean hasDot, hasComma = false;

    private String valueOne;

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
        buttonComma = findViewById(R.id.button_comma);

        buttonDelete = findViewById(R.id.button_delete);
        buttonErase = findViewById(R.id.button_erase);
    }

    private void listenForButtonInput() {

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "1");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "2");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "3");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "4");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "5");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "6");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "7");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "8");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "9");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValue.setText(inputValue.getText() + "0");

                hasComma = false;
                hasDot = false;
            }
        });

        buttonMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();

                hasDot = false;
                hasComma = false;

                computeMode();
            }
        });

        buttonMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();

                hasDot = false;
                hasComma = false;

                computeMean();
            }
        });

        buttonMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();

                hasDot = false;
                hasComma = false;

                computeMedian();
            }
        });

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasComma) {
                    int length = inputValue.getText().toString().length();
                    if (length != 0) {
                        inputValue.setText((inputValue.getText().toString()) + "," + "");
                    } else {
                        inputValue.setText(0 + "," + "");
                    }
                    hasComma = true;
                    hasDot = false;
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasDot) {
                    int length = inputValue.getText().toString().length();
                    if (length != 0) {
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
                    try {
                        if(inputValue.getText().toString().charAt(length - 1) == '.') {
                            inputValue.setText(inputValue.getText().subSequence(0, length - 1));
                        } else {
                            inputValue.setText(inputValue.getText().subSequence(0, length - 1));
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        Log.e(TAG, e.getMessage());
                        inputValue.setText("");
                    } catch (IndexOutOfBoundsException e) {
                        Log.d(TAG, e.getMessage());
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

    private void computeMode() {
        final String TAG = "computeMode()";

        valueOne = inputValue.getText().toString();
        Log.d(TAG, "valueOne: " + valueOne);

        if (valueOne != null) {

            String[] valueArray = valueOne.split(",");

            List<String> fixedList = Arrays.asList(valueArray);
            ArrayList<String> listOfNumbers = new ArrayList<String>(fixedList);
            int size = listOfNumbers.size();

            ArrayList<Integer> result = new ArrayList<Integer>();
            for (String valueString : valueArray) {
                result.add(Integer.parseInt(String.valueOf(valueString)));
            }

            inputValue.setText(mode(result, size));
        } else {
            Log.d(TAG, "Else valueOne: " + valueOne);
        }
    }


    public int mode(ArrayList<Integer> result, int size) {

        int maxValue = 0, maxCount = 0, i, j;

        for (i = 0; i < size; ++i) {
            int count = 0;
            for (j = 0; j < size; ++j) {
                if (result.get(j) == result.get(i))
                    ++count;
            }
        }
        return maxValue;
    }

    private void computeMean() {
        final String TAG = "computeMean()";

        valueOne = inputValue.getText().toString();
        Log.d(TAG, "valueOne: " + valueOne);

        if (valueOne != null) {
            String[] valueArrayString = valueOne.split(",");
            double[] arrayDouble = new double[valueArrayString.length];

            for (int i = 0; i < valueArrayString.length; i++) {
                arrayDouble[i] = Double.valueOf(valueArrayString[i]);
            }

            Log.d(TAG, "Length: " + arrayDouble.length);
            int size = arrayDouble.length;

            inputValue.setText(mean(arrayDouble, size).toString());

        } else {
            Log.d(TAG, "Else valueOne: " + valueOne);
        }
    }

    public Double mean(double[] result, int size) {
        double sum = 0;
        double output = 0;

        for (int index = 0; index < size; index++) {
            sum += result[index];
        }
        output = (sum / result.length);

        return output;
    }

    private void computeMedian() {
        final String TAG = "computeMedian()";

        valueOne = inputValue.getText().toString();
        Log.d(TAG, "valueOne: " + valueOne);

        if (valueOne != null) {


            String[] valueArrayString = valueOne.split(",");
            double[] arrayDouble = new double[valueArrayString.length];

            // Convert String to Double
            for (int i = 0; i < valueArrayString.length; i++) {
                arrayDouble[i] = Double.valueOf(valueArrayString[i]);
            }

            // Sort
            Arrays.sort(arrayDouble);

            for (Double sortedDouble : arrayDouble) {
                Log.d(TAG, String.valueOf(sortedDouble));
            }


            Log.d(TAG, "Length: " + arrayDouble.length);

            inputValue.setText(median(arrayDouble).toString());

        } else {
            Log.d(TAG, "Else valueOne: " + valueOne);
        }

    }

    public Double median(double[] m) {

        int middle = m.length / 2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle - 1] + m[middle]) / 2.0;
        }
    }

    private void eraseValues() {
        valueOne = null;
        hasDot = false;
        hasComma = false;
        inputValue.setText("");
    }


}
