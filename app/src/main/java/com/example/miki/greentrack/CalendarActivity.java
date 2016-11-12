package com.example.miki.greentrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

/**
 * Created by Miki on 11/12/2016.
 */

public class CalendarActivity extends AppCompatActivity{

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendar);
    }
}
