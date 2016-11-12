package com.example.darora.greentrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (CalendarView) findViewById(R.id.calendar);
        transactionList = new ArrayList<>();
        dateToTransactionMap = new HashMap<>();
        mRootRef = FirebaseDatabase.getInstance().getReference();
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
        /**
        mRootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Transaction childTrans = dataSnapshot.getValue(Transaction.class);
                ArrayList<Transaction> updatedTransactionList = dateToTransactionMap.get(
                        childTrans.getDate());
                if (updatedTransactionList == null){
                    updatedTransactionList = new ArrayList<Transaction>();
                }
                updatedTransactionList.add(childTrans);
                dateToTransactionMap.put(childTrans.getDate(), updatedTransactionList);
                transactionList.add(childTrans);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        **/
    }
    @Override
    protected void onStart(){
        super.onStart();
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
    }
}
