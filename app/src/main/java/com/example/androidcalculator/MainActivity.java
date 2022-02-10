package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button b1 = null;
    private Button b2 = null;
    private Button b3 = null;
    private Button b4 = null;
    private Button b5 = null;
    private Button b6 = null;
    private Button b7 = null;
    private Button b8 = null;
    private Button b9 = null;

    private Button bPlus = null;
    private Button bMin = null;
    private Button bMul = null;
    private Button bDiv = null;
    private Button bEq = null;

    private Button bDot = null;

    private Button bC = null;
    private Button bDel = null;

    private Button bMR = null;
    private Button bMC = null;
    private Button bMP = null;
    private Button bMM = null;


    private TextView text = null;
    private TextView memoryText = null;
    private String operation = "";
    private ArrayList<String> numBuffer = new ArrayList<String>();
    private String firstNum;
    private String secondNum;
    private String memory = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        bPlus = findViewById(R.id.buttonPlus);
        bMin = findViewById(R.id.buttonMinus);
        bMul = findViewById(R.id.buttonMul);
        bDiv = findViewById(R.id.buttonDiv);
        bEq = findViewById(R.id.buttonEq);

        bDot = findViewById(R.id.buttonPoint);

        bC = findViewById(R.id.buttonC);
        bDel = findViewById(R.id.buttonDEL);

        bMR = findViewById(R.id.buttonMR);
        bMC = findViewById(R.id.buttonMC);
        bMP = findViewById(R.id.buttonMP);
        bMM = findViewById(R.id.buttonMM);

        text = findViewById(R.id.text);
        memoryText = findViewById(R.id.memoryText);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digitClick("9");
            }
        });


        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick("+");
            }
        });

        bMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick("-");
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick("*");
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick("/");
            }
        });

        bEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalClick();
            }
        });

        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotClick();
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cClick();
            }
        });

        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delClick();
            }
        });

        bMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcClick();
            }
        });

        bMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrClick();
            }
        });

        bMP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpClick();
            }
        });

        bMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmClick();
            }
        });


    } //protected void onCreate(Bundle savedInstanceState) {


    public void digitClick(String digit) {

        this.numBuffer.add(digit);
        this.text.setText(bufferToString());


    }

    public void dotClick() {

        this.numBuffer.add(".");
        this.text.setText(bufferToString());

    }


    public void operationClick(String op) {

            this.setOperation(op);
            this.numberSet();
            this.text.setText(this.firstNum);
    }


    public void equalClick() {

        this.numberSet();
        if (this.secondNum != null) {
            calculate(this.firstNum, this.secondNum, this.operation);
        }

        this.text.setText(this.firstNum);
        this.operation = "";
        this.secondNum = null;
        this.numBuffer = stringToBuffer(this.firstNum);
        this.firstNum = null;

    }


    public void numberSet() {

        String num = bufferToString();

        if (this.firstNum == null) {
            this.firstNum = num;
        }
        else {
            this.secondNum = num;
            this.firstNum = calculate(this.firstNum, this.secondNum, this.operation);
            this.secondNum = null;
            this.operation = "";
        }

            this.numBuffer.clear();



    }


    public String calculate(String num1, String num2, String op) {
        switch (this.operation) {
            case "+":
                return Double.toString(Double.parseDouble(num1) + Double.parseDouble(num2));
            case "-":
                return Double.toString(Double.parseDouble(num1) - Double.parseDouble(num2));
            case "*":
                return Double.toString(Double.parseDouble(num1) * Double.parseDouble(num2));
            case "/":
                if (num2 == "0") {
                    return null;
                }
                return Double.toString(Double.parseDouble(num1) / Double.parseDouble(num2));
        }

        return null;
    }


    public void setOperation(String op) {
        this.operation = op;
    }


    public String bufferToString() {
        String num = "";
        for (String digit : this.numBuffer) {
            num += digit;
        }
        return num;
    }



    public ArrayList<String> stringToBuffer(String num) {
        ArrayList<String> buffer = new ArrayList<String>();
        for(int i = 0 ; i < num.length() ; i++) {
            buffer.add(String.valueOf(num.charAt(i)));
        }
        return buffer;
    }


    public void cClick() {
        this.numBuffer.clear();
        this.text.setText("");
    }

    public void delClick() {
        this.numBuffer.remove(this.numBuffer.size()-1);
        this.text.setText(bufferToString());
    }



    public void mpClick() {
        this.memory = Double.toString(Double.parseDouble(this.memory) + Double.parseDouble(bufferToString()));
        this.memoryText.setText("M");
    }

    public void mmClick() {
        this.memory = Double.toString(Double.parseDouble(this.memory) - Double.parseDouble(bufferToString()));
        this.memoryText.setText("M");
    }

    public void mcClick() {
        this.memory = "0";
        this.memoryText.setText("");
    }

    public void mrClick() {
        this.numBuffer = stringToBuffer(this.memory);
        this.text.setText(bufferToString());
    }


}