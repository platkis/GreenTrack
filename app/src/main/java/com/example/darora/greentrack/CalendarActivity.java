package com.example.darora.greentrack;

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
        mRootRef = FirebaseDatabase.getInstance().getReference();
        transactionList = new ArrayList<>();
        dateToTransactionMap = new HashMap<>();
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
        int i =3;
    }
}
