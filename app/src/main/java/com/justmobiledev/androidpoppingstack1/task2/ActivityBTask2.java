package com.justmobiledev.androidpoppingstack1.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.justmobiledev.androidpoppingstack1.BaseActivity;
import com.justmobiledev.androidpoppingstack1.R;

public class ActivityBTask2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startNextActivity();
    }

    private void startNextActivity(){

        Intent activity = new Intent(ActivityBTask2.this, ActivityCTask2.class);
        startActivity(activity);
    }
}
