package com.example.divyapatel.hotel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preference; //  declaring the preference (its like creating a new folder in the private memory of the app where you store password and username)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preference=getSharedPreferences("CheckFirstRun",MODE_PRIVATE);  // initializing the preference
        final boolean check = preference.getBoolean("isfirst",false);   // isfirst should be a sort of variable that store a value 'false'

        new android.os.Handler().postDelayed(new Runnable() {           // This is for splash screen...Runnable is used to make a new Thread
            @Override
            public void run() {             // Whatever you want to do..write in this RUN METHOD

                if (!check) {
                    preference.edit().putBoolean("isfirst",true).commit();
                    Intent intent = new Intent(SplashActivity.this,SignUpActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        },2000);            // Splash for a time interval

    }
}
