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

/**
 * Created by darora on 11/12/16.
 */

public class LimitsActivity extends AppCompatActivity {
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    Limits mLimits;
    private SeekBar mMiscBar;
    private TextView mMiscBarText;
    public double RefreshRateValue;
    private SettingsConfig mSettingsConfig;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        mMiscBar = (SeekBar) findViewById(R.id.sbMisc);
        super.onCreate(onSavedInstanceState);
        final DatabaseReference mLimitsRef = mRoot.child("limits");
        mMiscBarText = (TextView) findViewById(R.id.miscL);
//        mLimitsRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()){
//                    mLimits = dataSnapshot.getValue(Limits.class);
////                    mRefreshRateBar.setProgress( mSettingsConfig.getRefreshRate().intValue());
//                }
//                else {
//                    mLimitsRef.setValue(mLimits);
//                }
//
//            }


        // Sets up SeekBar
        mMiscBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String miscText = "- $" + String.valueOf(progress);

                RefreshRateValue = ((double) mMiscBar.getProgress());
                mSettingsConfig.setRefreshRate(refreshRateValue);
                mSettingsRef.child("refreshRate").setValue(mSettingsConfig.getRefreshRate());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
