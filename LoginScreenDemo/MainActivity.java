package com.example.akshay.loginscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button login;
    TextView attempt;
    EditText usr,pass;
    int attemptCount = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick();

    }

    private void onClick() {
        login = findViewById(R.id.login_button);
        attempt =findViewById(R.id.attempts);
        usr = findViewById(R.id.edit_user_id);
        pass = findViewById(R.id.edit_pass_id);
        attempt.setText(attemptCount+"");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usr.getText().toString().equals("Akshay1996") && pass.getText().toString().equals("Akshay"))
                {
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,SecondPage.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Invalid username & Password",Toast.LENGTH_SHORT).show();
                    attemptCount--;
                    attempt.setText(attemptCount+"");
                    if (attemptCount == 0)
                    {
                        login.setEnabled(false);
                    }
                }
            }
        });

    }
}
