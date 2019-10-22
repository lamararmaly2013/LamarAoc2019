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

public class ScheduleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView gridView;
    String[] listItems=new String[16];


    MainAdapter adapter;
    String subject;
    String[] dayWord= {"","MO","TU","WEN","THU","FRI",
                        "1","","","","","",
                        "2","","","","","",
                        "3","","","","","",
                        "4","","","","","",
                        "5","","","","","",
                        "6","","","","","",
                        "7","","","","","",
                        "8","","","","","",
                        "9","","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        gridView= findViewById(R.id.gridView);
        listItems= getResources().getStringArray(R.array.subject);



      adapter = new MainAdapter(ScheduleActivity.this,dayWord);
      gridView.setAdapter(adapter);



        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

        if(position >  5 ) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(ScheduleActivity.this);
            mBuilder.setTitle("Choose Subject");

            mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    subject = listItems[which];
                    dayWord[position] = subject;
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            });
            // create and show the alert dialog
            AlertDialog dialog = mBuilder.create();
            dialog.show();
        }


    }
}
