package com.justmobiledev.androidpoppingstack1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActivityB extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startNextActivity();
    }

    private void startNextActivity(){

        Intent activity = new Intent(ActivityB.this, ActivityC.class);
        activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(activity);

    }
}
