package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Drink {
    private int id;
    private String name;
    private String address;
    private String description;
    private int imageResourceId;
    private float ratingStar;


    public static final Drink[] drinks = {
            new Drink(1,"Bramble", "16a Queen Street", "Subterranean venue, serving classic and nouveau concoctions", R.drawable.bramble,3),
            new Drink(2,"Panda & Sons", "79 Queen Street", "Edinburghs very own speakeasy", R.drawable.panda_family,3),
            new Drink(3,"Byant & Mack Detectives", "87-89 Rose Street", "Uncover some exceptional cocktails here", R.drawable.bryantmack,3)

    };

    private Drink(int id, String name, String address, String description, int imageResourceId, float ratingStar){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.ratingStar = ratingStar;

    }

    public float getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(float ratingStar) {
        this.ratingStar = ratingStar;
    }

    public int getId(){
        return id;
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
