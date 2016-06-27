package com.example.root.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username, password, attempts;
    private static Button button;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginAction();
    }


    public  void loginAction() {
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        attempts = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
        attempts.setText(Integer.toString(attempt_counter));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals("payoda@123") && username.getText().toString().equals("user")) {
                    Toast.makeText(Login.this, "you have logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.root.login.User");
                    startActivity(intent);
                    //attempt_counter = 5;
                } else {
                    Toast.makeText(Login.this, "Incorrent username and password", Toast.LENGTH_SHORT).show();
                    attempt_counter--;
                    attempts.setText(Integer.toString(attempt_counter));
                    if(attempt_counter ==0) {
                        button.setEnabled(false);
                    }

                }
            }
        });


    }
}
