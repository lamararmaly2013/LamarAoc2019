package y2019.aoc.lamar.lamaraoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddHomeWorkActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home_work);

        buttonAddToList= findViewById(R.id.ButtonSchedule);
        buttonAddToList.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == buttonAddToList) {

            Intent i = new Intent(this, HomeWorkActivity.class);
            startActivity(i);

        }
    }
}