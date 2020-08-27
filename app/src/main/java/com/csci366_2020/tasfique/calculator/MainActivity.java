package com.csci366_2020.tasfique.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add, btn_Sub, btn_Mul, btn_Div, btn_calc, btn_dec, btn_clear;
    EditText mEditText;
    String input = "";

    float Value1, Value2, Value3, Value4;
    boolean mAddition, mSubtract, mMultiplication, mDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_Add = (Button) findViewById(R.id.btn_Add);
        btn_Div = (Button) findViewById(R.id.btn_Div);
        btn_Sub = (Button) findViewById(R.id.btn_Sub);
        btn_Mul = (Button) findViewById(R.id.btn_Mul);
        btn_calc = (Button) findViewById(R.id.btn_calc);
        btn_dec = (Button) findViewById(R.id.btn_dec);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        mEditText = (EditText) findViewById(R.id.edText1);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mEditText.setText(mEditText.getText() + "0");
                input +=  mEditText.getText() + "0";
                mEditText.setText(input);
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mEditText.setText(mEditText.getText() + "1");
                input += input + mEditText.getText() + "1";
                mEditText.setText(input);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mEditText.setText(mEditText.getText() + "2");
                input += mEditText.getText() + "2";
                mEditText.setText(input);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mEditText.setText(mEditText.getText() + "3");
                input += mEditText.getText() + "3";
                mEditText.setText(input);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "9");
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + ".");
            }
        });

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="*";
            }
        });

        btn_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.split("\\*").length==2){
                    String numbers[]=input.split("\\*");
                    try{
                        double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                        input=mul+"";
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                else if(input.split("/").length==2){
                    String numbers[]=input.split("/");
                    try{
                        double div=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                        input=div+"";
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                else if(input.split("\\^").length==2){
                    String numbers[]=input.split("\\^");
                    try{
                        double pow=Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
                        input=pow+"";
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                else if(input.split("\\+").length==2){
                    String numbers[]=input.split("\\+");
                    try{
                        double sum=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                        input=sum+"";
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                else if(input.split("\\-").length>1){
                    String numbers[]=input.split("\\-");
                    if(numbers[0]=="" && numbers.length==2){
                        numbers[0]=0+"";
                    }
                    try{
                        double sub=0;
                        if(numbers.length==2) {
                            sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                        }
                        else if(numbers.length==3){
                            sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                        }
                        input=sub+"";
                    }
                    catch (Exception e){
                        //Display error
                    }
                }
                String n[]=input.split("\\.");
                if(n.length>1){
                    if(n[1].equals("0")){
                        input=n[0];
                    }
                }
                mEditText.setText(input);

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });
    }

}

