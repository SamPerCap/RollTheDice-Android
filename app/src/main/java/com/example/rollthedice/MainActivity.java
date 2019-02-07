package com.example.rollthedice;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG = "xyz";
    Button rollButton, clearButton;
    TextView historyText;
    Integer randomNumber, result, drawableID;
    LinearLayout horizontalLayout;
    ImageView leftImage, rightImage;
    Integer[] twoValues = new Integer[]{0,0};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locateItems();
        leftImage.setImageResource(R.drawable.dice_side_1);
        rightImage.setImageResource(R.drawable.dice_side_6);
    }

    private void locateItems() {
        Log.d(TAG,"Locating items...");
        rollButton = this.findViewById(R.id.buttonRoll);
        leftImage = this.findViewById(R.id.imageView);
        rightImage = this.findViewById(R.id.imageView2);
        historyText = this.findViewById(R.id.historyTextView);
        horizontalLayout = this.findViewById(R.id.linearLayout);
        horizontalLayout.setOrientation(LinearLayout.VERTICAL);
        clearButton = this.findViewById(R.id.clearButton);
    }

    public void rollLogic(View view) {
        Log.d(TAG, "Rolling the dice");
        leftImage.setImageResource(calculateSide(0));
        rightImage.setImageResource(calculateSide(1));
        doMaths();
    }

    private int doMaths() {
        Log.d(TAG,"Doing maths..");
        result = twoValues[0] + twoValues[1];
        addHistory();
        return result;
    }

    private void addHistory() {
        Log.d(TAG, "Adding a new history entrance");
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView newHistory = new TextView(this);
        newHistory.setText(""+twoValues[0]+" + "+twoValues[1]+ " = " + result);
        horizontalLayout.addView(newHistory);
        newHistory.setLayoutParams(lparams);
    }

    private Integer calculateSide(Integer arrayPosition){
        Log.d(TAG, "Deciding the side...");
       int sideByRandom = doRandomNumber();
       int position = arrayPosition;
       switch (sideByRandom){
           case 1:
               drawableID = R.drawable.dice_side_1;
               twoValues[position] = 1;
               break;
           case 2:
               drawableID = R.drawable.dice_side_2;
               twoValues[position] = 2;
               break;
           case 3:
               drawableID = R.drawable.dice_side_3;
               twoValues[position] = 3;
               break;
           case 4:
               drawableID = R.drawable.dice_side_4;
               twoValues[position] = 4;
               break;
           case 5:
               drawableID = R.drawable.dice_side_5;
               twoValues[position] = 5;
               break;
           case 6:
               drawableID = R.drawable.dice_side_6;
               twoValues[position] = 6;
               break;
       }
        return drawableID;
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
