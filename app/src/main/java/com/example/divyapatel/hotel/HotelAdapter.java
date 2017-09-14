package com.example.divyapatel.hotel;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by divyapatel on 27/07/17.
 */

class HotelAdapter extends BaseAdapter {

    public final SecondActivity secondActivity;
    public final List<Hotel> hotels;

    public HotelAdapter(SecondActivity secondActivity, List<Hotel> hotels) {

        this.secondActivity=secondActivity;
        this.hotels=hotels;
    }

    @Override
    public int getCount() {
        return hotels.size();
    }

    @Override
    public Object getItem(int i) {
        return hotels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(secondActivity).inflate(R.layout.row,viewGroup,false);

        ImageView image = (ImageView)view.findViewById(R.id.row_image);
        TextView name = (TextView)view.findViewById(R.id.name_rowtv);
        TextView cuisine = (TextView)view.findViewById(R.id.cuisine_rowtv);

        Hotel hotel = hotels.get(i);
        image.setImageResource(hotel.getImage_id());
        name.setText(hotel.getName());
        cuisine.setText(hotel.getCuisine());

        return view;
    }
}
