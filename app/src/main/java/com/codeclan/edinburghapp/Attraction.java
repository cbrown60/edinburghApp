package com.codeclan.edinburghapp;

/**
 * Created by user on 20/03/2017.
 */

public class Attraction {
    private int id;
    private String name;
    private String address;
    private String description;
    private int imageResourceId;
    private float ratingStar;


    public static final Attraction[] attractions = {
            new Attraction(1,"Edinburgh Dungeons", "16a Queen Street", "Subterranean venue, serving classic and nouveau concoctions", R.drawable.dungeon,3),
            new Attraction(2,"Graveyard Tour", "79 Queen Street", "Edinburghs very own speakeasy", R.drawable.graveyard,3),
            new Attraction(3,"Mary Kings Close", "87-89 Rose Street", "Uncover some exceptional cocktails here", R.drawable.marykings,3)

    };

    private Attraction(int id, String name, String address, String description, int imageResourceId,float ratingStar){
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


    public float getRatingStar(){
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
