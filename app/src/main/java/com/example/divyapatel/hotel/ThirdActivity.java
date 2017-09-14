package com.example.divyapatel.hotel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button call;
    TextView name, locate, cuisine;
    Bundle b;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        image= (ImageView) findViewById(R.id.hotel_image);
        name = (TextView) findViewById(R.id.single_hotel);
        locate = (TextView) findViewById(R.id.single_locate);
        cuisine = (TextView) findViewById(R.id.single_cuisine);
        call = (Button) findViewById(R.id.single_call);
         b = getIntent().getExtras();
        name.setText(b.getString("name"));
        locate.setText(b.getString("location"));
        cuisine.setText(b.getString("cuisine"));
        switch (b.getInt("position"))
        {
            case 0:
                image.setImageResource(R.drawable.indian_accent_newyork_bar);
                break;
            case 1:
                image.setImageResource(R.drawable.peshwari);
                break;
            case 2:
                image.setImageResource(R.drawable.villa_maya);
                break;
            case 3:
                image.setImageResource(R.drawable.karawali);
                break;
            case 4:
                image.setImageResource(R.drawable.thalassa);
                break;
            case 5:
                image.setImageResource(R.drawable.malaka_spice);
                break;
        }
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + b.getString("phone_number")));
                ActivityCompat.requestPermissions(ThirdActivity.this,new String []{Manifest.permission.CALL_PHONE},1);
                if (ActivityCompat.checkSelfPermission(ThirdActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);
            }
        });

    }
}
