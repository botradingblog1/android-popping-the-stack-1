package com.justmobiledev.androidpoppingstack1.task2;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.justmobiledev.androidpoppingstack1.BaseActivity;
import com.justmobiledev.androidpoppingstack1.MainActivity;
import com.justmobiledev.androidpoppingstack1.R;

import java.util.List;

public class ActivityCTask2 extends BaseActivity {
    TextView taskInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskInfoTextView = (TextView) findViewById(R.id.textview_task_info);

        Button clearTopButton = findViewById(R.id.button_clear_top);
        clearTopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popStackFlag = true;

                Intent intent = new Intent(ActivityCTask2.this, ActivityATask2.class);
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
