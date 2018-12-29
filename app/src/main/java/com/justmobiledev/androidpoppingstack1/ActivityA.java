package com.justmobiledev.androidpoppingstack1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.justmobiledev.androidpoppingstack1.broadcast_receivers.PopStackReceiver;
import com.justmobiledev.androidpoppingstack1.constants.Constants;

public class ActivityA extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startNextActivity();
    }

    private void startNextActivity(){

        Intent activity = new Intent(ActivityA.this, ActivityB.class);
        startActivity(activity);

    }
}
