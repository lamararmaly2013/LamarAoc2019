package y2019.aoc.lamar.lamaraoc2019;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {

    GridView gridView;
    String[] listItems=new String[16];



    String[] dayWord= {"","Monday","Tuesday","Wednesday","Thursday","Friday",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",
                        "","","","","","",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        gridView= findViewById(R.id.gridView);
        listItems= getResources().getStringArray(R.array.subject);



      final MainAdapter adapter= new MainAdapter(ScheduleActivity.this,dayWord);
      gridView.setAdapter(adapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.notifyDataSetChanged();

                AlertDialog.Builder mBuilder= new AlertDialog.Builder(ScheduleActivity.this);
                mBuilder.setTitle("Choose Subject");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }


        });


    }
}
