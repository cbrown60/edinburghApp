package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Drink {

    private String name;
    private String address;
    private String description;
    private int imageResourceId;
//        private float ratingStar;


    public static final Drink[] drinks = {
            new Drink("Bramble", "16a Queen Street", "Subterranean venue, serving classic and nouveau concoctions", R.drawable.bramble),
            new Drink("Panda & Sons", "79 Queen Street", "Edinburghs very own speakeasy", R.drawable.panda_family),
            new Drink("Byant & Mack Detectives", "87-89 Rose Street", "Uncover some exceptional cocktails here", R.drawable.bryantmack)

    };

    private Drink(String name, String address, String description, int imageResourceId){
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
        return imageResourceId ;
    }

    public String toString(){
        return this.name;
    }
}
