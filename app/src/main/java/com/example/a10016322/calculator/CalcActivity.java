package com.example.a10016322.calculator; //copy paste the entire file except this line

//insert try-catch
//do exceptions
//doesn't subtract, multiply, or divide negative numbers bc there are 2 negative signs in the string
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.StringTokenizer;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener
{
    String currentVal = "";
    boolean equ = false;
    TextView onScreen;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        onScreen = (TextView)(findViewById(R.id.textView_ans));
        ((Button)findViewById(R.id.button_0)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_1)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_2)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_3)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_4)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_5)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_6)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_7)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_8)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_9)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_plus)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_minus)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_mult)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_div)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_c)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_eq)).setOnClickListener(this);

    }
    //possible errors: 2 signs next to each other, divide by 0

    @Override
    public void onClick(View v)
    {
        try {
            switch (v.getId()) {
                case (R.id.button_c):
                    onScreen.setText("");
                    num = 0;
                    equ = false;
                    currentVal = "";
                    break;
                case (R.id.button_eq):
                    if (currentVal.contains("+")) {
                        num = 0;
                        StringTokenizer tokenizer = new StringTokenizer(currentVal, "+");
                        while (tokenizer.hasMoreTokens()) {
                            String next = tokenizer.nextToken();
                            num += Integer.parseInt(next);
                        }
                        currentVal = Integer.toString(num);
                        onScreen.setText(currentVal);
                    } else if (currentVal.contains("-")) {
                        StringTokenizer tokenizer = new StringTokenizer(currentVal, "-");
                        num = Integer.parseInt(tokenizer.nextToken().substring(0, currentVal.indexOf("-")));
                        while (tokenizer.hasMoreTokens()) {
                            String next = tokenizer.nextToken();
                            num -= Integer.parseInt(next);
                        }
                        currentVal = Integer.toString(num);
                        onScreen.setText(currentVal);
                    } else if (currentVal.contains("*")) {
                        num = 1;
                        StringTokenizer tokenizer = new StringTokenizer(currentVal, "*");
                        while (tokenizer.hasMoreTokens()) {
                            String next = tokenizer.nextToken();
                            num *= Integer.parseInt(next);
                        }
                        currentVal = Integer.toString(num);
                        onScreen.setText(currentVal);
                    } else if (currentVal.contains("/")) {
                        StringTokenizer tokenizer = new StringTokenizer(currentVal, "/");
                            Double num = Double.parseDouble(tokenizer.nextToken().substring(0, currentVal.indexOf("/")));
                            while (tokenizer.hasMoreTokens()) {
                                String next = tokenizer.nextToken();
                                num /= Double.parseDouble(next);
                            }
                            if (num == num.intValue())
                                currentVal = Integer.toString(num.intValue());
                            else currentVal = Double.toString(num);
                            onScreen.setText(currentVal);
                    }
                    equ = true;
                    break;

                default:
                    currentVal += ((Button) v).getText();
                    onScreen.setText(currentVal);
            }
        }catch(Exception e){
            onScreen.setText("Error");
        }

    }



}

