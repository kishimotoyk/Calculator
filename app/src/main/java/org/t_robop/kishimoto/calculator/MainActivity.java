package org.t_robop.kishimoto.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int temp = 0;//一時保存用

    int a = 0, b = 0;//計算用

    int sum = 0;//計算結果用

    int mark;//記号

    TextView resultText;//結果表示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = (TextView)findViewById(R.id.resultText);
    }

    public void numClick(View v){
        String num = String.valueOf(v.getTag());
        temp = temp * 10 + Integer.parseInt(num);
        resultText.setText(String.valueOf(temp));

    }

    public void markClick(View v){
        String num = String.valueOf(v.getTag());
        mark = Integer.parseInt(num);
        a = temp;
        temp = 0;

    }

    public void equalClick(View v){
        b = temp;

        switch(mark){
            case 0:
                sum = a + b;
                break;
            case 1:
                sum = a - b;
                break;
            case 2:
                sum = a * b;
                break;
            case 3:

                if (b == 0) {
                    sum = 0;
                }
                else {
                    sum = a / b;
                }
                break;
            default:
                break;
        }
        resultText.setText(String.valueOf(sum));


        temp = 0;
    }
    public void ClearClick(View v){
        a = 0;
        b = 0;
        temp = 0;
        mark = 0;
        resultText.setText(String.valueOf(0));
    }

}
