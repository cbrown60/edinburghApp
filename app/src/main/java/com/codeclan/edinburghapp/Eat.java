package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Eat {

    private int id;
    private String name;
    private String address;
    private String description;
    private int imageResourceId;
//        private float ratingStar;


    public static final Eat[] eats = {
            new Eat(1, "Ting Thai Caravan", "8-9 Teviot Place", "Authentic thai street food", R.drawable.tingthai),
            new Eat(2, "El Cartrel", "64 Thistle Street", "Authentic mexican street food", R.drawable.cartel),
            new Eat(3, "Bread Meats Bread", "92 Lothian Road", "Probably the best burgers", R.drawable.bmb)

    };

    private Eat(int id, String name, String address, String description, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageResourceId = imageResourceId;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }


    public String toString() {
        return this.name;

    }

}