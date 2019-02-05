package com.example.rollthedice;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = "xyz";
    Button rollButton, clearButton;
    TextView leftText, rightText, historyText;
    Integer randomNumber, firstNumber, secondNumber, result;
    LinearLayout horizontalLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locateItems();
        leftText.setText(String.valueOf(doRandomNumber()));
        rightText.setText(String.valueOf(doRandomNumber()));
    }

    private void locateItems() {
        Log.d(TAG,"Locating items...");
        rollButton = this.findViewById(R.id.buttonRoll);
        leftText = this.findViewById(R.id.leftTextView);
        rightText = this.findViewById(R.id.rightTextView);
        historyText = this.findViewById(R.id.historyTextView);
        horizontalLayout = this.findViewById(R.id.linearLayout);
        horizontalLayout.setOrientation(LinearLayout.VERTICAL);
        clearButton = this.findViewById(R.id.clearButton);
    }

    public void rollLogic(View view) {
        Log.d(TAG, "Rolling the dice");
        leftText.setText(String.valueOf(doRandomNumber()));
        rightText.setText(String.valueOf(doRandomNumber()));
        doMaths();
    }

    private int doMaths() {
        Log.d(TAG,"Doing maths..");
        String oneValue = leftText.getText().toString();
        String twoValue = rightText.getText().toString();
        firstNumber = Integer.parseInt(oneValue);
        secondNumber = Integer.parseInt(twoValue);
        result = firstNumber + secondNumber;
        addHistory();
        return result;
    }

    private void addHistory() {
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView newHistory = new TextView(this);
        newHistory.setText(""+firstNumber+" + "+secondNumber+ " = " + result);
        horizontalLayout.addView(newHistory);
        newHistory.setLayoutParams(lparams);
    }


    public int doRandomNumber(){
        Log.d(TAG, "Random number in process");
    Random rand = new Random();
    randomNumber = rand.nextInt(6) + 1;
    return randomNumber;
    }

    public void clearHistory(View view) {
        horizontalLayout.removeAllViews();
    }
}
