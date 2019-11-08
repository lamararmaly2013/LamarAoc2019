package y2019.aoc.lamar.lamaraoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeWorkActivity extends AppCompatActivity{

    ArrayList<HomeWork> homeWorks;
    ListView hwlv;


//*
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Users/"+user.getUid()+"/HW");
//*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);

        homeWorks = new ArrayList<>();
        // homeWorks.add();
       //* myRef.push().setValue(new HomeWork("CS", "Java HW", null, false));
        //homeWorks.add(new HomeWork("Arabic", "insha HW", null, false));
        //homeWorks.add(new HomeWork("CS", "Java HW", null, false));

        //homeWorks.add(new HomeWork("CS", "Java HW", null, false));

        hwlv = findViewById(R.id.HomeWorkListView);
        final CustomAdapter2 adapter2= new CustomAdapter2(this, R.layout.activity_check_box_list, homeWorks);
        hwlv.setAdapter(adapter2);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HomeWork hw = dataSnapshot.getValue(HomeWork.class);
                //Toast.makeText(this, "Inside child added", Toast.LENGTH_SHORT).show();
                homeWorks.add(hw);
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


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
                Intent i= new Intent(this ,AddHomeWorkActivity.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "add homework", Toast.LENGTH_SHORT).show();

        }
        return true;

    }

}
