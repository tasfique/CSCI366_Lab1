package com.csci366_2020.tasfique.calculator;

//import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add, btn_Sub, btn_Mul, btn_Div, btn_calc, btn_dec, btn_clear;
    TextView mTextView, mTextView2;
    String process;


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
        mTextView = (TextView) findViewById(R.id.edText1);
        mTextView2 = (TextView) findViewById(R.id.edText2);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "9");
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + ".");
            }
        });

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "+");
            }
        });

        btn_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "-");
            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "*");
            }
        });

        btn_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                mTextView.setText(process + "/");
            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = mTextView.getText().toString();
                process = process.replaceAll("x", "*");
                //process = process.replaceAll("")
                Context rhino =  Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                mTextView2.setText(finalResult);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input = "";
                mTextView.setText("");
                mTextView2.setText("");
            }
        });
    }

    /*public void Solve() {
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                input = mul + "";
            } catch (Exception e) {
                //Display error
            }
        } else if (input.split("/").length == 2) {
            String numbers[] = input.split("/");
            try {
                double div = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                input = div + "";
            } catch (Exception e) {
                //Display error
            }
        } else if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                input = pow + "";
            } catch (Exception e) {
                //Display error
            }
        } else if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                input = sum + "";
            } catch (Exception e) {
                //Display error
            }
        } else if (input.split("\\-").length > 1) {
            String numbers[] = input.split("\\-");
            if (numbers[0] == "" && numbers.length == 2) {
                numbers[0] = 0 + "";
            }
            try {
                double sub = 0;
                if (numbers.length == 2) {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                } else if (numbers.length == 3) {
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input = sub + "";
            } catch (Exception e) {
                //Display error
            }
        }
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        mTextView.setText(input);

    }*/

}

