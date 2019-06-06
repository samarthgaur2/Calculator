package com.example.mycalc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private enum Operators{
        plus,minus,multiply,divide,equals
    }
    TextView txtTop;
    TextView txtResult;
    private String currentNumber;
    private String NumberOnLeft;
    private String NumberOnRight;
    private Operators currentOperator;
    private int calculatedResult;

    private String calculations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber="";
        calculatedResult=0;

        calculations="";

        txtTop = findViewById(R.id.TextTop);
        txtResult = findViewById(R.id.TextResult);
        findViewById(R.id.btnEquals).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.btn1:
            numberClicked(1);
            break;
            case R.id.btn2:
                numberClicked(2);
                break;
            case R.id.btn3:
                numberClicked(3);
                break;
            case R.id.btnDivide:
                operatorClicked(Operators.divide);
                calculations+=" / ";
                break;
            case R.id.btn4:
                numberClicked(4);
                break;
            case R.id.btn5:
                numberClicked(5);
                break;
            case R.id.btn6:
                numberClicked(6);
                break;
            case R.id.btnMultiply:
                operatorClicked(Operators.multiply);
                calculations+=" * ";
                break;
            case R.id.btn7:
                numberClicked(7);
                break;
            case R.id.btn8:
                numberClicked(8);
                break;
            case R.id.btn9:
                numberClicked(9);
                break;
            case R.id.btnPlus:
                operatorClicked(Operators.plus);
                calculations+=" + ";
                break;
            case R.id.btnClear:
                clearClicked();
                break;
            case R.id.btn0:
                numberClicked(0);
                break;
            case R.id.btnMinus:
                operatorClicked(Operators.minus);
                calculations+=" - ";
                break;
            case R.id.btnEquals:
                operatorClicked(Operators.equals);
                break;

        }
        txtTop.setText(calculations);

    }
    private void numberClicked(int clickedNumber){
        currentNumber += String.valueOf(clickedNumber);
        txtResult.setText(currentNumber);
        calculations = currentNumber;
        txtTop.setText(calculations);

    }
    private void operatorClicked(Operators clickedOperator){
        if(currentOperator!=null) {
            if(currentNumber!="") {
                NumberOnRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case plus:
                        calculatedResult = Integer.parseInt(NumberOnLeft) + Integer.parseInt(NumberOnRight);
                        break;
                    case minus:
                        calculatedResult = Integer.parseInt(NumberOnLeft) - Integer.parseInt(NumberOnRight);
                        break;
                    case multiply:
                        calculatedResult = Integer.parseInt(NumberOnLeft) * Integer.parseInt(NumberOnRight);
                        break;
                    case divide:
                        calculatedResult = Integer.parseInt(NumberOnLeft) / Integer.parseInt(NumberOnRight);
                        break;
                    case equals:
                        break;
                }
                NumberOnLeft = String.valueOf(calculatedResult);
                txtResult.setText(NumberOnLeft);
                calculations = NumberOnLeft;
            }
        }
        else{
            NumberOnLeft = currentNumber;
            currentNumber="";
        }
        currentOperator = clickedOperator;
    }
    private void clearClicked(){
        NumberOnLeft="";
        NumberOnRight="";
        calculatedResult=0;
        currentNumber="";
        currentOperator=null;
        txtResult.setText("0");
        calculations="";
        txtTop.setText("0");

    }
}
