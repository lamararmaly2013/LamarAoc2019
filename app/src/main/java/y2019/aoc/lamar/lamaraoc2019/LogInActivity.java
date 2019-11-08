package y2019.aoc.lamar.lamaraoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FIREBASE";
    EditText  editTextEmail , editTextPassword;
    Button buttonLogIn , buttonSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword =findViewById(R.id.editTextPassword);

        buttonLogIn = findViewById(R.id.ButtonLogin);
        buttonLogIn.setOnClickListener(this);
        buttonSignUp = findViewById(R.id.ButtonSignUp);
        buttonSignUp.setOnClickListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LogInActivity.this, HomePageActivity.class);
                            i.putExtra("email", editTextEmail.getText().toString());
                            i.putExtra("password", editTextPassword.getText().toString());
                            startActivity(i);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v==buttonLogIn) {

            if(editTextEmail.getText().toString().equals("")||editTextPassword.getText().toString().equals("")){
                Toast.makeText(this,"Empty Email or Password" , Toast.LENGTH_LONG).show();
            }

            else{
            signIn(editTextEmail.getText().toString(),editTextPassword.getText().toString());


            }

        }

        else{

            Intent i= new Intent(this ,SignUpActivity.class);
            startActivity(i);
        }
    }

}
