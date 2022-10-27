package com.example.lesson72;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Double first, second;
    private Boolean isOperationClick;
    private String operation;
    private Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                btnNumber(1);
                break;
            case R.id.btn_two:
                btnNumber(2);
                break;
            case R.id.btn_three:
                btnNumber(3);
                break;
            case R.id.btn_four:
                btnNumber(4);
                break;
            case R.id.btn_five:
                btnNumber(5);
                break;
            case R.id.btn_six:
                btnNumber(6);
                break;
            case R.id.btn_seven:
                btnNumber(7);
                break;
            case R.id.btn_eight:
                btnNumber(8);
                break;
            case R.id.btn_nine:
                btnNumber(9);
                break;
            case R.id.btn_zero:
                btnNumber(0);
                break;
            case R.id.btn_dot:
                text.append(".");
                break;
            case R.id.btn_clear:
                text.setText("0");
                first = 0.0;
                second = 0.0;
                break;
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                btnOperation("+");
                break;
            case R.id.btn_minus:
                btnOperation("-");
                break;
            case R.id.btn_multiplication:
                btnOperation("*");
                break;
            case R.id.btn_division:
                btnOperation("/");
                break;

            case R.id.btn_equals:
                second = Double.valueOf(text.getText().toString());
                if (operation == "+") {
                    result = first + second;
                }else if (operation == "-"){
                    result = first - second;
                }else if (operation == "x"){
                    result = first * second;
                }else if (operation == "/"){
                    result = first / second;
                }
                text.setText(result.toString());
                break;
        }
        isOperationClick = true;
    }

    public void btnOperation(String operation){
        this.operation = operation;
        first = Double.valueOf(text.getText().toString());
    }

    public void btnNumber(Integer num) {
        if (text.getText().toString().equals("0")) {
            text.setText(num.toString());
        } else if (isOperationClick) {
            text.setText(num.toString());
        } else {
            text.append(num.toString());
        }

    }
}