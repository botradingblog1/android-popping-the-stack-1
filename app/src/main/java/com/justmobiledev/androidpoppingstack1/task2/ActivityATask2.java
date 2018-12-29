package com.justmobiledev.androidpoppingstack1.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.justmobiledev.androidpoppingstack1.ActivityB;
import com.justmobiledev.androidpoppingstack1.BaseActivity;
import com.justmobiledev.androidpoppingstack1.R;

public class ActivityATask2 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (!popStackFlag) {
            startNextActivity();
        }

        popStackFlag = false;
    }

    private void startNextActivity(){

        Intent activity = new Intent(ActivityATask2.this, ActivityBTask2.class);
        startActivity(activity);

    }
}
