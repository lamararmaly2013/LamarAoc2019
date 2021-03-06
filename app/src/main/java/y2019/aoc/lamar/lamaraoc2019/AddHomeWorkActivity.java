package y2019.aoc.lamar.lamaraoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddHomeWorkActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddToList, buttonChooseSubject, buttonDueDate;
    EditText editTextDescription;

    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Users/" + user.getUid() + "/HW");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home_work);


        editTextDescription = findViewById(R.id.editTextDescription);
        buttonAddToList = findViewById(R.id.ButtonAddToList);
        buttonAddToList.setOnClickListener(this);
        buttonChooseSubject = findViewById(R.id.ChooseSubjectButton);
        buttonChooseSubject.setOnClickListener(this);
        buttonDueDate = findViewById(R.id.DueDateButton);
        buttonDueDate.setOnClickListener(this);

    }
}

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


            AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddHomeWorkActivity.this);
            mBuilder.setTitle("Choose Subject");

            mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    subject = listItems[which];
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            });
            // create and show the alert dialog
            AlertDialog dialog = mBuilder.create();
            dialog.show();
        }


  /*  }

    public void onClick(View v) {
        if (v == buttonAddToList) {

            Intent i = new Intent(this, HomeWorkActivity.class);
            myRef.push().setValue(new HomeWork("cs", editTextDescription.getText().toString(), null, false));
            startActivity(i);

        }
    }
}