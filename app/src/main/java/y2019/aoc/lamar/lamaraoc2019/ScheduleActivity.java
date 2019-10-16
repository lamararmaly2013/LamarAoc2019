package y2019.aoc.lamar.lamaraoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {

    GridView gridView;

    String[] dayWord= {"Monday","Tuesday","Wednesday","Thursday","Friday"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        gridView= findViewById(R.id.gridView);

        MainAdapter adapter= new MainAdapter(ScheduleActivity.this,dayWord);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "you clicked"+dayWord[+position],Toast.LENGTH_SHORT).show();
            }
        });


    }
}
