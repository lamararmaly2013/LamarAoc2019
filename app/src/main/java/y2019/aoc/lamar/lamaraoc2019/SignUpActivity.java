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


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FirebaseAuth";
    EditText editTextEmail, editTextPassword, editTextConfirmPassword;
    Button buttonSignUp;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String ConfirmPassword = getIntent().getStringExtra("confirm password");

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonSignUp = findViewById(R.id.ButtonSignUp);
        buttonSignUp.setOnClickListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void signUp(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
             //               updateUI(user);
                            Intent i = new Intent(SignUpActivity.this, HomePageActivity.class);
                            i.putExtra("email", editTextEmail.getText().toString());
                            i.putExtra("password", editTextPassword.getText().toString());
                            i.putExtra("confirm password", editTextConfirmPassword.getText().toString());
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
              //              updateUI(null);
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSignUp) {

            if (editTextConfirmPassword.getText().toString().equals("")
                    ||editTextEmail.getText().toString().equals("")
                    || editTextPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Empty Email or Password", Toast.LENGTH_LONG).show();
            }

            else {
                signUp(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }


            if (!editTextConfirmPassword.getText().toString().equals(editTextPassword)) {
            }
        }

        else {
            Intent i = new Intent(this, HomePageActivity.class);
            startActivity(i);
        }

    }

}

