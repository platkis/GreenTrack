package com.example.darora.greentrack;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miki on 11/12/2016.
 */

public class DailyReportActivity extends AppCompatActivity {

    LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.acitivity_daily_report);
        mLayout =(LinearLayout) findViewById(R.id.daily_report_layout);
        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();
        ArrayList<Transaction> transactionList = (ArrayList<Transaction>) receivedBundle.getSerializable(
                "transactionList");
        if (transactionList != null) {
            for (int i = 0; i < transactionList.size(); i++) {
                TextView txtView = new TextView(DailyReportActivity.this);
                txtView.setText(transactionList.get(i).getDate() + "\t" +
                        transactionList.get(i).getName() + "\t" + transactionList.get(i).getAmount());
                txtView.setTextSize(15);
                txtView.setPadding(0, (i * 30), 0, 0);
                mLayout.setBackgroundColor(Color.TRANSPARENT);
                mLayout.addView(txtView);
            }
        }
    }
}
