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
            new Sleep(1,"Tigerlilly", "125 George Street", "Tigerlily is an award-winning boutique hotel with chic rooms, an elegant bar, nightclub and a restaurant. It is a 10-minute walk from the Scott Monument in Edinburgh’s most popular shopping area and financial district.\n" +
                    "\n" +
                    "In Edinburgh's city centre, the hotel on George Street has beautiful rooms with a flat-screen TV and Bluetooth speaker. Guests can also enjoy luxurious White Company toiletries and free WiFi.\n" +
                    "\n" +
                    "Tigerlily has a cocktail bar which also serves locally sourced meals, and guests receive free entry to Lulu nightclub and bar, downstairs.\n" +
                    "\n" +
                    "The surrounding New Town district is filled with stylish cocktail bars and smart restaurants.\n" +
                    "\n" +

                    "\n", R.drawable.tigerlilly,3),
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
