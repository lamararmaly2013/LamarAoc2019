package y2019.aoc.lamar.lamaraoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSchedule , buttonHomeWork, buttonExams, buttonReminer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        buttonSchedule= findViewById(R.id.ButtonSchedule);
        buttonSchedule.setOnClickListener(this);

        buttonHomeWork = findViewById(R.id.ButtonHomework);
        buttonHomeWork.setOnClickListener(this);

        buttonExams = findViewById(R.id.ButtonExams);
        buttonExams.setOnClickListener(this);

        buttonReminer= findViewById(R.id.ButtonReminder);
        buttonReminer.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.LogOut:
                Toast.makeText(getBaseContext(), "Log Out", Toast.LENGTH_LONG).show();

        }
        return true;

    }

    @Override
    public void onClick(View v) {
        if(v==buttonSchedule) {

            Intent i= new Intent(this, ScheduleActivity.class);
            startActivity(i);

        }

        else if(v==buttonHomeWork){

            Intent i= new Intent(this ,HomeWorkActivity.class);
            startActivity(i);
        }

        else if(v==buttonExams){

            Intent i= new Intent(this ,ExamsActivity.class);
            startActivity(i);
        }

        else if(v==buttonReminer){

            Intent i= new Intent(this ,ReminderActivity.class);
            startActivity(i);
        }
    }
}