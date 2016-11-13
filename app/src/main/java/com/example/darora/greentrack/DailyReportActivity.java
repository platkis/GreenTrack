package com.example.darora.greentrack;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miki on 11/12/2016.
 */

public class DailyReportActivity extends AppCompatActivity {

    GridLayout mLayout;
    int textSize;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.acitivity_daily_report);
        mLayout = (GridLayout) findViewById(R.id.daily_report_layout);
        textSize = 20;
        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();
        ArrayList<Transaction> transactionList = (ArrayList<Transaction>) receivedBundle.getSerializable(
                "transactionList");
        if (transactionList != null) {
            //android.support.v7.app.ActionBar actionbar = getSupportActionBar();
           // actionbar.setTitle(transactionList.get(0).getDate());
            for (int i = 0; i < transactionList.size(); i++) {
                TextView nameTV = new TextView(DailyReportActivity.this);
                String nameText = transactionList.get(i).getName();
              //  nameTV.setGravity(Gravity.START);
                nameTV.setText(nameText);
                nameTV.setTextSize(textSize);
                //nameTV.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                mLayout.setBackgroundColor(Color.TRANSPARENT);
                /**
                GridLayout.LayoutParams param1 =new GridLayout.LayoutParams();
                param1.height = GridLayout.LayoutParams.WRAP_CONTENT;
                param1.width = GridLayout.LayoutParams.MATCH_PARENT;
                param1.leftMargin = 10;
                param1.setGravity(Gravity.START | Gravity.FILL);
                nameTV.setLayoutParams(param1);
                 **/
                GridLayout.Spec titleTxtSpecColumn1 = GridLayout.spec(1, GridLayout.LEFT);
                GridLayout.Spec titleRowSpec1 = GridLayout.spec(i);
                mLayout.addView(nameTV, new GridLayout.LayoutParams(titleRowSpec1 , titleTxtSpecColumn1));





                TextView amountTV = new TextView(DailyReportActivity.this);
                String amountText = "" + transactionList.get(i).getAmount();
                //amountTV.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                //amountTV.setGravity(Gravity.END);
                amountTV.setText(amountText);
                amountTV.setTextSize(textSize);
                /**
                GridLayout.LayoutParams param2 =new GridLayout.LayoutParams();
                param2.height = GridLayout.LayoutParams.WRAP_CONTENT;
                param2.width = GridLayout.LayoutParams.MATCH_PARENT;
                param2.rightMargin = 20;
                param2.setGravity(Gravity.END | Gravity.FILL);
                amountTV.setLayoutParams(param2);
                //param.topMargin = 5;
                 **/


                GridLayout.Spec titleTxtSpecColumn2 = GridLayout.spec(2, GridLayout.RIGHT);
                GridLayout.Spec titleRowSpec2 = GridLayout.spec(i);
                mLayout.addView(amountTV, new GridLayout.LayoutParams(titleRowSpec2 , titleTxtSpecColumn2));
                mLayout.setBackgroundColor(Color.TRANSPARENT);

            }
        }
    }
}
