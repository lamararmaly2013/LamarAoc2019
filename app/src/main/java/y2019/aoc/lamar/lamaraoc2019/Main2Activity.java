package y2019.aoc.lamar.lamaraoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    ArrayList<HomeWork> homeWorks = new ArrayList<>();
    MyRecyclerViewAdapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rv = findViewById(R.id.recycleViewList);
        homeWorks.add(new HomeWork("Haneen", "Haneen", new Date(), true));
        homeWorks.add(new HomeWork("Haneen", "Haneen", new Date(), true));
        homeWorks.add(new HomeWork("Haneen", "Haneen", new Date(), true));
        homeWorks.add(new HomeWork("Haneen", "Haneen", new Date(), true));

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, homeWorks);
      //  adapter.setClickListener(this);
        rv.setAdapter(adapter);


       /*adapter2= new MyRecyclerViewAdapter(this, homeWorks);
        rv.setAdapter(adapter2);*/
       // hwlv.setAdapter(adapter2);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(Main2Activity.this, "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(Main2Activity.this, "on Swiped ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                homeWorks.remove(position);
                adapter.notifyDataSetChanged();

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(rv);
    }
}
