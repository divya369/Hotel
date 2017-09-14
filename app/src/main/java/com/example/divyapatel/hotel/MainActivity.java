package com.example.divyapatel.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user_name,password;
    Button quit,submit;
    ImageView hotel_image;
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preference = getSharedPreferences("Username_password",MODE_PRIVATE);
        user_name=(EditText)findViewById(R.id.userEt);
        password=(EditText)findViewById(R.id.passEt);
        quit=(Button)findViewById(R.id.quiteBtn);
        submit=(Button)findViewById(R.id.submitBtn);
        hotel_image=(ImageView)findViewById(R.id.hotel_wallpapers);

        String perf_user = preference.getString("perf_user","");
        String perf_pass = preference.getString("perf_pass","");

        if (!perf_user.isEmpty()) {
            user_name.setText(perf_user);
        }
        if (!perf_pass.isEmpty()) {
            password.setText(perf_pass);
        }

        quit.setOnClickListener(this);
        submit.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int a=0;
        switch (view.getId()) {
            case R.id.quiteBtn :
                password.setText("");
                user_name.setText("");
                a=1;

                Intent intent=new Intent(Intent.ACTION_MAIN);           // to quit to the home screen
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            case R.id.submitBtn :
                if (user_name.getText().toString().isEmpty()) {
                    user_name.setError("Enter your Username");
                    a=1;
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Enter Password");
                    a=1;
                }
             /*   if (!user_name.getText().toString().equals("admin")) {
                    user_name.setText("");
                    Toast.makeText(this,"Try Again",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                else {
                    user_name.setText("");
                    a=1;
                }
                if (!password.getText().toString().equals("admin123")) {
                    password.setText("");
                    Toast.makeText(this,"Try Again",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                else {
                    password.setText("");
                    a=0;
                }  */
                if (a==0) {

                    String name = user_name.getText().toString();
                    String pass = password.getText().toString();
                    preference.edit().putString("perf_user",name).commit();
                    preference.edit().putString("perf_pass",pass).commit();

                    Toast.makeText(this, "Welcome Buddy", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent1);
                }
        }
    }
}