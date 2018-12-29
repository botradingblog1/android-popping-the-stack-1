package com.justmobiledev.androidpoppingstack1.new_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.justmobiledev.androidpoppingstack1.ActivityB;
import com.justmobiledev.androidpoppingstack1.BaseActivity;
import com.justmobiledev.androidpoppingstack1.R;

public class ActivityASingleTask extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startNextActivity();
    }

    private void startNextActivity(){

        Intent activity = new Intent(ActivityASingleTask.this, ActivityB.class);
        activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(activity);


    }
}
