package com.example.darora.greentrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;
/**
 * Created by darora on 11/12/16.
 */

public class LimitsActivity extends AppCompatActivity {
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    Limits mLimits;
    private SeekBar mMiscBar;
    private TextView mMiscBarText;
    public double miscValue;
    private DatabaseReference mLimitsRef;
    private Button mConfirmButton;
    private SeekBar mFoodBar;
    private TextView mFoodBarText;
    private SeekBar mCreditBar;
    private TextView mCreditBarText;
    private SeekBar mGroceriesBar;
    private TextView mGroceriesBarText;
    private SeekBar mCoffeeBar;
    private TextView mCoffeeBarText;
    private SeekBar mMedicalBar;
    private TextView mMedicalBarText;
    private SeekBar mClothingBar;
    private TextView mClothingBarText;
    private SeekBar mElectronicsBar;
    private TextView mElectronicsBarText;
    private SeekBar mShoppingBar;
    private TextView mShoppingBarText;
    public double foodValue;
    public double creditValue;
    public double groceryValue;
    public double coffeeValue;
    public double medicalValue;
    public double clothingValue;
    public double electronicsValue;
    public double shoppingValue;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_limits);
        mMiscBar = (SeekBar) findViewById(R.id.sbMisc);
        mMiscBarText = (TextView) findViewById(R.id.miscNum);
        mFoodBar = (SeekBar) findViewById(R.id.sbFoodDining);
        mFoodBarText = (TextView) findViewById(R.id.foodDiningNum);
        mCreditBar = (SeekBar) findViewById(R.id.sbCreditCard);
        mCreditBarText = (TextView) findViewById(R.id.creditCardNum);
        mGroceriesBar = (SeekBar) findViewById(R.id.sbGroceries);
        mGroceriesBarText = (TextView) findViewById(R.id.groceriesNum);
        mCoffeeBar = (SeekBar) findViewById(R.id.sbCoffee);
        mCoffeeBarText = (TextView) findViewById(R.id.coffeeNum);
        mConfirmButton = (Button) findViewById(R.id.confirmButton);
        mMedicalBar = (SeekBar) findViewById(R.id.sbMedical);
        mMedicalBarText = (TextView) findViewById(R.id.medicalNum);
        mClothingBar = (SeekBar) findViewById(R.id.sbClothing);
        mClothingBarText = (TextView) findViewById(R.id.clothingNum);
        mElectronicsBar = (SeekBar) findViewById(R.id.sbElectronics);
        mElectronicsBarText = (TextView) findViewById(R.id.electronicsNum);
        mShoppingBar = (SeekBar) findViewById(R.id.sbShopping);
        mShoppingBarText = (TextView) findViewById(R.id.shoppingNum);
        mLimitsRef = mRoot.child("limits");
        mMiscBarText.setText(String.valueOf(mMiscBar.getProgress()));
        mFoodBarText.setText(String.valueOf(mFoodBar.getProgress()));
        mCoffeeBarText.setText(String.valueOf(mCoffeeBar.getProgress()));
        mGroceriesBarText.setText(String.valueOf(mGroceriesBar.getProgress()));
        mMedicalBarText.setText(String.valueOf(mMedicalBar.getProgress()));
        mClothingBarText.setText(String.valueOf(mClothingBar.getProgress()));
        mElectronicsBarText.setText(String.valueOf(mElectronicsBar.getProgress()));
        mShoppingBarText.setText(String.valueOf(mShoppingBar.getProgress()));
        mLimits = new Limits();
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

        mLimitsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Limits Sliders = dataSnapshot.getValue(Limits.class);
                mMiscBar.setProgress((int) Sliders.getMiscellaneous());
                mFoodBar.setProgress((int) Sliders.getFood());
                mCreditBar.setProgress((int) Sliders.getCreditCard());
                mGroceriesBar.setProgress((int) Sliders.getGroceries());
                mCoffeeBar.setProgress((int) Sliders.getCoffee());
                mMedicalBar.setProgress((int) Sliders.getMedical());
                mClothingBar.setProgress((int) Sliders.getClothing());
                mElectronicsBar.setProgress((int) Sliders.getElectronics());
                mShoppingBar.setProgress((int) Sliders.getShopping());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        // Sets up SeekBar
        mMiscBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String miscText = "- $" + String.valueOf(progress);

                mMiscBarText.setText(miscText);

                miscValue = ((double) mMiscBar.getProgress());

                mLimits.setMiscellaneous(miscValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mFoodBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String foodText = "- $" + String.valueOf(progress);

                mFoodBarText.setText(foodText);

                foodValue = ((double) mFoodBar.getProgress());

                mLimits.setFood(foodValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCreditBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String creditText = "- $" + String.valueOf(progress);

                mCreditBarText.setText(creditText);

                creditValue = ((double) mCreditBar.getProgress());

                mLimits.setCreditCard(creditValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mGroceriesBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String groceriesText = "- $" + String.valueOf(progress);

                mGroceriesBarText.setText(groceriesText);

                groceryValue = ((double) mGroceriesBar.getProgress());

                mLimits.setGroceries(groceryValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCoffeeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String coffeeText = "- $" + String.valueOf(progress);

                mCoffeeBarText.setText(coffeeText);

                coffeeValue = ((double) mCoffeeBar.getProgress());

                mLimits.setCoffee(coffeeValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mMedicalBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String medicalText = "- $" + String.valueOf(progress);

                mMedicalBarText.setText(medicalText);

                medicalValue = ((double) mMedicalBar.getProgress());

                mLimits.setMedical(medicalValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mClothingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String clothingText = "- $" + String.valueOf(progress);

                mClothingBarText.setText(clothingText);

                clothingValue = ((double) mClothingBar.getProgress());

                mLimits.setClothing(clothingValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mElectronicsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String electronicsText = "- $" + String.valueOf(progress);

                mElectronicsBarText.setText(electronicsText);

                electronicsValue = ((double) mElectronicsBar.getProgress());

                mLimits.setElectronics(electronicsValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mShoppingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String shoppingText = "- $" + String.valueOf(progress);

                mShoppingBarText.setText(shoppingText);

                shoppingValue = ((double) mShoppingBar.getProgress());

                mLimits.setShopping(shoppingValue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLimitsRef.setValue(mLimits);
                Toast successToast = new Toast(LimitsActivity.this);
                Toast.makeText(LimitsActivity.this, "Updated online database!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
