package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Sleep {
    private int id;
    private String name;
    private String address;
    private String description;
    private int imageResourceId;
    private float ratingStar;


    public static final Sleep[] sleeps = {
            new Sleep(1,"Tigerlilly", "125 George Street", "Upscale boutique living", R.drawable.tigerlilly,3),
            new Sleep(2,"Le Monde", "16 George Street", "Central party pad", R.drawable.lemonde,3),
            new Sleep(3,"Witchery", "352 Castle Hill", "Unique experience", R.drawable.witchery,3)

    };

    private Sleep(int id, String name, String address, String description, int imageResourceId, float ratingStar){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.ratingStar = ratingStar;

    }
    public int getId(){
        return id;
    }

    public float getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(float ratingStar) {
        this.ratingStar = ratingStar;
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
