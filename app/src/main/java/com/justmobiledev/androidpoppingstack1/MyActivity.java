package com.justmobiledev.androidpoppingstack1;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.justmobiledev.androidpoppingstack1.task2.ActivityATask2;
import com.justmobiledev.androidpoppingstack1.task2.ActivityCTask2;

import java.util.List;

public class MyActivity extends BaseActivity {

    TextView taskInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskInfoTextView = (TextView) findViewById(R.id.textview_task_info);

        // Get info from intent
        Intent intent = getIntent();
        String id = intent.getStringExtra(Constants.KEY_ACTIVITY_INDEX);

        int numActivities = intent.getIntExtra(Constants.KEY_NUM_ACTIVITIES_TO_CREATE, 0);
        String activityName = "Activity "+id;
        setTitle(activityName);
        numActivities--;

        // Start new Activity
        if (numActivities > 0){
            Intent nextIntent = new Intent(this, MyActivity.class);
            nextIntent.putExtra(Constants.KEY_ACTIVITY_INDEX, numActivities);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        // Add clear button listener
        Button clearTopButton = findViewById(R.id.button_clear_top);
        clearTopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popStackFlag = true;

                Intent intent = new Intent(MyActivity.this, MyActivity.class);
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
