package y2019.aoc.lamar.lamaraoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvPassword);

        tvEmail.setText(email);
        tvPassword.setText(password);



    }
}
