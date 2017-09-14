package com.example.divyapatel.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name, number, email, password, confirm_password;
    Button quit,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.nameEt);
        number = (EditText) findViewById(R.id.numberEt);
        email = (EditText) findViewById(R.id.emailEt);
        password = (EditText) findViewById(R.id.passwordEt);
        confirm_password = (EditText) findViewById(R.id.confirmpassEt);
        quit = (Button) findViewById(R.id.quitBtn);
        submit = (Button) findViewById(R.id.submitBtn);

        quit.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quitBtn :

             /*   name.setText("");
                number.setText("");
                email.setText("");
                password.setText("");
                confirm_password.setText("");   */

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            case R.id.submitBtn :

             /*   name.setText("");
                number.setText("");
                email.setText("");
                password.setText("");
                confirm_password.setText("");   */

                if (name.getText().toString().isEmpty()) {
                    name.setError("Enter Name");
                }
                if (number.getText().toString().isEmpty()) {
                    number.setError("Enter Number");
                }
                if (email.getText().toString().isEmpty()) {
                    email.setError("Enter Email ID");
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Enter New Password");
                }
                if (confirm_password.getText().toString().isEmpty()) {
                    confirm_password.setError("Enter Confirm Password");
                    return;
                }
                if(!password.getText().toString().equals(confirm_password.getText().toString()))
                {
                    Toast.makeText(this,"Your Password is Not Matching",Toast.LENGTH_SHORT).show();
                    password.setText("");
                    confirm_password.setText("");
                    return;
                }

                Toast.makeText(this,"Welcone Buddy",Toast.LENGTH_SHORT).show();
                Intent intent1 =  new Intent(SignUpActivity.this,SecondActivity.class);
                startActivity(intent1);

        }
    }
}
