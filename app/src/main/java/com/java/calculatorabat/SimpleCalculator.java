package com.java.calculatorabat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculator extends AppCompatActivity {

    public static final String TAG = "SimpleCalculator";
    TextView inputValue;

    Button buttonSeven, buttonEight, buttonNine, buttonAddition; //First row
    Button buttonFour, buttonFive, buttonSix, buttonMinus; //Second row
    Button buttonOne, buttonTwo, buttonThree, buttonMultiplication; //Third Row
    Button buttonDot, buttonZero, buttonEqual, buttonDivision; //Fourth Row
    Button buttonDelete, buttonErase; //Fifth Row

    private boolean isAddition, isSubtraction, isMultiplication, isDivision = false;
    private boolean hasDot = false;

    private String valueOne, valueTwo;

    private Double inputOne, inputTwo = 0.0;
    private Double inputResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        initializeFields();
        listenForButtonInput();
    }

    private void initializeFields() {
        inputValue = findViewById(R.id.input_value);

        buttonSeven = findViewById(R.id.button_7);
        buttonEight = findViewById(R.id.button_8);
        buttonNine = findViewById(R.id.button_9);
        buttonAddition = findViewById(R.id.button_addition);

        buttonFour = findViewById(R.id.button_4);
        buttonFive = findViewById(R.id.button_5);
        buttonSix = findViewById(R.id.button_6);
        buttonMinus = findViewById(R.id.button_subtract);

        buttonOne = findViewById(R.id.button_1);
        buttonTwo = findViewById(R.id.button_2);
        buttonThree = findViewById(R.id.button_3);
        buttonMultiplication = findViewById(R.id.button_multiply);

        buttonDot = findViewById(R.id.button_dot);
        buttonZero = findViewById(R.id.button_0);
        buttonEqual = findViewById(R.id.button_equals);
        buttonDivision = findViewById(R.id.button_divide);

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

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isAddition = true;
                isSubtraction = false;
                isMultiplication = false;
                isDivision = false;

                hasDot = false;

            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText("-");

                isAddition = false;
                isSubtraction = true;
                isMultiplication = false;
                isDivision = false;

                hasDot = false;
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isAddition = false;
                isSubtraction = false;
                isMultiplication = true;
                isDivision = false;

                hasDot = false;
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = inputValue.getText().toString();
                inputValue.setText(null);

                isAddition = false;
                isSubtraction = false;
                isMultiplication = false;
                isDivision = true;

                hasDot = false;
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
                        inputValue.setText((inputValue.getText().toString()) + ".");
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


    public void computeValues() {
        if(inputValue.getText().toString().isEmpty() || inputValue.getText().toString() == "") { // Treat as no value or null
            inputValue.setText("");
        }  else {
            inputResult = 0.0;

            valueTwo = inputValue.getText().toString();
            inputOne = Double.parseDouble(valueOne);
            inputTwo = Double.parseDouble(valueTwo);
            inputValue.setText(null);

            if (isAddition) {
                hasDot = false;
                inputResult = (inputOne + inputTwo);
                inputValue.setText(inputResult + "");
            } else if (isSubtraction) {
                hasDot = false;
                inputResult = (inputOne - inputTwo);
                inputValue.setText(inputResult + "");
            } else if (isMultiplication) {
                hasDot = false;
                inputResult = (inputOne * inputTwo);
                inputValue.setText(inputResult + "");
            } else if (isDivision) {
                hasDot = false;
                inputResult = (inputOne / inputTwo);
                inputValue.setText(inputResult + "");
            } else {
                Toast.makeText(this, "Something happened.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Compute Values | Input Value ELSE: " + inputValue.toString());
                debugValues();
            }
        }
    }

    private void eraseValues() {
        inputOne = null;
        inputTwo = null;
        valueOne = null;
        valueTwo = null;
        hasDot = false;
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
