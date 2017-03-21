package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Sleep {
    private String name;
    private String address;
    private String description;
    private int imageResourceId;
//        private float ratingStar;


    public static final Sleep[] sleeps = {
            new Sleep("Tigerlilly", "125 George Street", "Upscale boutique living", R.drawable.tigerlilly),
            new Sleep("Le Monde", "16 George Street", "Central party pad", R.drawable.lemonde),
            new Sleep("Witchery", "352 Castle Hill", "Unique experience", R.drawable.witchery)

    };

    private Sleep(String name, String address, String description, int imageResourceId){
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

    public String toString(){
        return this.name;
    }
}
