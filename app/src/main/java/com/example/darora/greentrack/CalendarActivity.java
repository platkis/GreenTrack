package com.example.darora.greentrack;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CalendarActivity extends AppCompatActivity {

    CalendarView mCalendarView;
    DatabaseReference mRootRef;
    ArrayList<Transaction> transactionList;
    HashMap<String, ArrayList<Transaction>> dateToTransactionMap;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    Button mSetLimitsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_test);
        Toolbar actionBar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(actionBar);
        mSetLimitsButton = (Button) findViewById(R.id.set_limits_button);
        mCalendarView = (CalendarView) findViewById(R.id.calendar);
        transactionList = new ArrayList<>();
        dateToTransactionMap = new HashMap<>();
        mRootRef = FirebaseDatabase.getInstance().getReference();


        NavigationView mDrawerList = (NavigationView) findViewById(R.id.main_navigation);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, actionBar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 for (DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                 Transaction childTrans = childSnapshot.getValue(Transaction.class);
                 ArrayList<Transaction> updatedTransactionList = dateToTransactionMap.get(
                 childTrans.getDate());
                 if (updatedTransactionList == null){
                 updatedTransactionList = new ArrayList<Transaction>();
                 }
                 updatedTransactionList.add(childTrans);
                 dateToTransactionMap.put(childTrans.getDate(), updatedTransactionList);
                 transactionList.add(childTrans);
                 }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int y, int m, int d) {
                String day;
                if (d < 10){
                    day = "0" + d;
                }
                else {
                    day = "" + d;
                }
                String jsonFormatString = String.valueOf(y) + String.valueOf(m+1) + day;
                ArrayList<Transaction> transactionList = dateToTransactionMap.get(jsonFormatString);
                Intent intent = new Intent(CalendarActivity.this, DailyReportActivity.class);
                intent.putExtra("transactionList",transactionList);
                startActivity(intent);
            }
        });

        mSetLimitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalendarActivity.this, LimitsActivity.class));
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /**
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    Transaction childTrans = childSnapshot.getValue(Transaction.class);
                    ArrayList<Transaction> updatedTransactionList = dateToTransactionMap.get(
                            childTrans.getDate());
                    if (updatedTransactionList == null){
                        updatedTransactionList = new ArrayList<Transaction>();
                    }
                    updatedTransactionList.add(childTrans);
                    dateToTransactionMap.put(childTrans.getDate(), updatedTransactionList);
                    transactionList.add(childTrans);
                }
                 **/
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
