package com.example.divyapatel.hotel;

/**
 * Created by divyapatel on 27/07/17.
 */

class Hotel {

    private final String name;
    private final String location;
    private final String cuisine;
    private final String number;
    private final int image_id;

    public Hotel(String name, String location, String cuisine, String number, int image_id) {
        this.name=name;
        this.cuisine=cuisine;
        this.location=location;
        this.number=number;
        this.image_id = image_id;
    }

    public String getName() {return name;}
    public String getCuisine() {return cuisine;}
    public String getLocation() {return location;}
    public String getNumber() {return number;}
    public int getImage_id() {return image_id;}
}
