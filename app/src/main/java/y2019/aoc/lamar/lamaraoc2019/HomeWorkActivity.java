package y2019.aoc.lamar.lamaraoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeWorkActivity extends AppCompatActivity {

    ArrayList<HomeWork> homeWorks;
    ListView hwlv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);

        homeWorks = new ArrayList<>();
        homeWorks.add(new HomeWork("CS", "Java HW", null, false));
        homeWorks.add(new HomeWork("Arabic", "insha HW", null, true));
        homeWorks.add(new HomeWork("CS", "Java HW", null, false));

        homeWorks.add(new HomeWork("CS", "Java HW", null, false));
        hwlv= findViewById(R.id.HomeWorkListView);
        CustomAdapter2 adapter2= new CustomAdapter2(this, R.layout.activity_check_box_list, homeWorks);
        hwlv.setAdapter(adapter2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addhomework, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addHomeWork:
                Toast.makeText(getBaseContext(), "add homework", Toast.LENGTH_SHORT).show();

        }
        return true;

    }

}
