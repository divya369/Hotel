package com.example.divyapatel.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    ListView hotel_list;
    List<Hotel> hotels;
    HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        hotel_list=(ListView)findViewById(R.id.hotellist);
        hotels=new ArrayList<>();
        hotels.add(new Hotel("Indian Accent","New Delhi","Vegetarian friendly","9879521126",R.drawable.indian_accent_newyork_bar));
        hotels.add(new Hotel("Peshawri","ITC Maratha, Mumbai","Indian and Asian ","9874672291",R.drawable.peshwari));
        hotels.add(new Hotel("Villa Maya","Thiruvananthapuram","Indian and Italian specialities","9836747725",R.drawable.villa_maya));
        hotels.add(new Hotel("Karavalli","Bengaluru ","Indian, seafood, Asian","9987678853",R.drawable.karawali));
        hotels.add(new Hotel("Thalassa","Vagator, Goa","Seafood, Mediterranean, Greek","9878864431",R.drawable.thalassa));
        hotels.add(new Hotel("Malaka Spice","Pune","Thai, Indonesian, Asian","8977679453",R.drawable.malaka_spice));

        hotelAdapter = new HotelAdapter(this,hotels);

        hotel_list.setAdapter(hotelAdapter);

        hotel_list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent=new Intent(this,ThirdActivity.class);
        Bundle bundle=new Bundle();
        TextView textView=view.findViewById(R.id.name_rowtv);
        String name=textView.toString();

        Hotel hotel = hotels.get(i);
        bundle.putString("name",hotel.getName());
        bundle.putString("cuisine",hotel.getCuisine());
        bundle.putString("location",hotel.getLocation());
        bundle.putString("phone_number",hotel.getNumber());
        bundle.putInt("position",i);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
