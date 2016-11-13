package com.example.darora.greentrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by darora on 11/13/16.
 */

public class NotificationActivity extends AppCompatActivity {
    HashMap<String, Double> cats = new HashMap<>();
    DatabaseReference mRootRef;
    DatabaseReference mLimitsRef;
    TextView misc;
    Limits l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootRef = FirebaseDatabase.getInstance().getReference();
        misc = (TextView) findViewById(R.id.misc);
        cats.put("miscellaneous", 0.0);
        cats.put("food", 0.0);
        cats.put("creditCard", 0.0);
        cats.put("groceries", 0.0);
        cats.put("coffee", 0.0);
        cats.put("medical", 0.0);
        cats.put("clothing", 0.0);
        cats.put("electronics", 0.0);
        cats.put("shopping", 0.0);

        mLimitsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                l = dataSnapshot.getValue(Limits.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
                String formatted = df.format(date);
                System.out.println(formatted);
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    Transaction child = childSnapshot.getValue(Transaction.class);
                    if(child.getDate().equals(formatted)) {
                        String category = child.getCategory();
                        double amount = child.getAmount();
                        double curr = cats.get(category);
                        cats.put(category, amount + curr);
                    }
                }

                String over = "You spent $";
                String over2 = " too much";
                String under = "You saved $";

                String miscStr = "Miscellaneous: ";
                if(cats.get("miscellaneous") > l.getMiscellaneous()) {
                    misc.setText(miscStr + over + (cats.get("miscellaneous") - l.getMiscellaneous()) + over2);
                }
                else {
                    misc.setText(miscStr + under + (l.getMiscellaneous() - cats.get("miscellaneous")));
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
