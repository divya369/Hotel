package com.example.divyapatel.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecurityPermission;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences preferences;
    EditText username, password;
    Button signin, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        preferences = getSharedPreferences("username_password",MODE_PRIVATE);
        username = (EditText)findViewById(R.id.signInUser);
        password = (EditText) findViewById(R.id.signInPass);
        String perf_user = preferences.getString("perf_user","");
        String perf_pass = preferences.getString("perf_pass", "");
        signin = (Button)findViewById(R.id.signinBtn);
        quit = (Button)findViewById(R.id.quiteBtn);

        signin.setOnClickListener(this);
        quit.setOnClickListener(this);

        if(!perf_user.isEmpty()) {              // At first go, the perf_user will be Empty..so it will enter the if condition
            username.setText(perf_user);       // Then it will set the perf_user same as the username
        }
        if (!perf_pass.isEmpty()) {
            password.setText(perf_pass);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signinBtn:

                String name = username.getText().toString();
                String pass = password.getText().toString();
                preferences.edit().putString("perf_user", name).commit();
                preferences.edit().putString("perf_pass", pass).commit();

                Intent intent = new Intent(SignInActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

            case R.id.quiteBtn:

                //  System.exit(0);    will take you to the firstActivity of the app
                //  finish();
                //  android.os.Process.killProcess(android.os.Process.myPid());
                //  super.onDestroy();

                Intent intent1 = new Intent(Intent.ACTION_MAIN);      // works perfectly
                intent1.addCategory(Intent.CATEGORY_HOME);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
        }
    }
}
