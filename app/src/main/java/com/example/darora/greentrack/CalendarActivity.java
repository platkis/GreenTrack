package com.example.darora.greentrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarActivity extends AppCompatActivity {

    CalendarView mCalendarView;
    DatabaseReference mRootRef;
    HashMap<String, ArrayList<Transaction>> dateToTransactionMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (CalendarView) findViewById(R.id.calendar);

        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    Transaction childTrans = childSnapshot.getValue(Transaction.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
