package com.example.darora.greentrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by darora on 11/12/16.
 */

public class LimitsActivity extends AppCompatActivity {
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    Limits mLimits;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        final DatabaseReference mLimitsRef = mRoot.child("limits");

        mLimitsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    mLimits = dataSnapshot.getValue(Limits.class);
//                    mRefreshRateBar.setProgress( mSettingsConfig.getRefreshRate().intValue());
                }
                else {

//                    mLimits = new Limits(1.0, true);
                    mLimitsRef.setValue(mLimits);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
