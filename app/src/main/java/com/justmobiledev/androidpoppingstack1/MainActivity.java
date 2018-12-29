package com.justmobiledev.androidpoppingstack1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.justmobiledev.androidpoppingstack1.new_task.ActivityASingleTask;

public class MainActivity extends BaseActivity {

    Button oneTaskStackButton;
    Button twoTaskStackButton;

    public MainActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        oneTaskStackButton = findViewById(R.id.button_one_task_stack);
        oneTaskStackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityA = new Intent(MainActivity.this, ActivityA.class);
                startActivity(activityA);

               /*  Intent activityB = new Intent(MainActivity.this, ActivityB.class);
                startActivity(activityB);

                Intent activityC = new Intent(MainActivity.this, ActivityC.class);
                startActivity(activityC);*/
            }
        });

        twoTaskStackButton = findViewById(R.id.button_two_task_stack);
        twoTaskStackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent(MainActivity.this, ActivityASingleTask.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(activity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {

        popStackFlag = false;

        super.onResume();
    }
}
