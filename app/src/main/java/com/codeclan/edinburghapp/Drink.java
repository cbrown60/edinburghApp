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
            new Drink(2,"Panda & Sons", "79 Queen Street", "Panda & Sons opened in November 2013 by Panda and his family. The foundation the bar was built on was to create a place where all ages and all people would feel welcome whether it would be for one of our deliciously creative cocktails, wide range of craft beers or our extensive wine list.\n" +
                    "\n" +
                    "We are a hidden bar fusing the classic Prohibition style Speakeasy and a nod to the Vintage style Barbershop. All we can say is that if you find a Barbershop with some foreign currency you have made it to the Libation Destination!", R.drawable.panda_family,3),
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
