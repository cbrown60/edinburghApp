package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Eat {

    private String name;
    private String address;
    private String description;
    private int imageResourceId;
//        private float ratingStar;


    public static final Eat[] eats = {
            new Eat("Ting Thai Caravan", "8-9 Teviot Place", "Authentic thai street food", R.drawable.tingthai),
            new Eat("El Cartrel", "64 Thistle Street", "Authentic mexican street food", R.drawable.cartel),
            new Eat("Bread Meats Bread", "92 Lothian Road", "Probably the best burgers", R.drawable.bmb)

    };

    private Eat(String name, String address, String description, int imageResourceId) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageResourceId = imageResourceId;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String toString() {
        return this.name;

    }

}