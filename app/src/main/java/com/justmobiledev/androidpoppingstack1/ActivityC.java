package com.justmobiledev.androidpoppingstack1;

import android.app.ActivityManager;
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
import android.widget.Button;
import android.widget.TextView;

import com.justmobiledev.androidpoppingstack1.broadcast_receivers.PopStackReceiver;
import com.justmobiledev.androidpoppingstack1.constants.Constants;

import java.util.List;

public class ActivityC extends BaseActivity {
    TextView taskInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskInfoTextView = (TextView) findViewById(R.id.textview_task_info);

        // Register Buttons
        Button onResumeButton = findViewById(R.id.button_on_resume);
        onResumeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popStackFlag = true;
                finish();
            }
        });

        Button clearTopButton = findViewById(R.id.button_clear_top);
        clearTopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityC.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                // Finish current activity
                finish();
            }
        });

        showTasks();

    }

    private void showTasks(){
        StringBuilder builder = new StringBuilder();

        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(100);
        for (int i=0; i < taskInfo.size(); i++){
            String topActivityName = taskInfo.get(i).topActivity.getClassName();
            String baseActivityName = taskInfo.get(i).baseActivity.getClassName();
            builder.append("Task: "+i+"\n");
            builder.append("Top Activity: "+topActivityName+"\n");
            builder.append("Base Activity: "+baseActivityName+"\n");
            builder.append("-------------\n");
        }
        taskInfoTextView.setText(builder.toString());
    }
}
