package com.codeclan.edinburghapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Attr;

import java.util.ArrayList;

public class AttractionActivity extends Activity {
    public static String EXTRA_ATTRACTIONNO = "attractionNo";
    public RatingBar ratingBar;
    public Attraction attraction;
    public static final String RATINGS = "ratings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        int attractionNo =(Integer)getIntent().getExtras().get(EXTRA_ATTRACTIONNO);
        attraction = Attraction.attractions[attractionNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(attraction.getImageResourceId());
        photo.setContentDescription(attraction.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(attraction.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(attraction.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(attraction.getDescription());

        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar

        // Sets up our shared preferences and gets info back
        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Attraction.attractions);
        String attractions = sharedPref.getString("attractionRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Attraction>> attractionsArrayList = new TypeToken<ArrayList<Attraction>>(){};
        ArrayList<Attraction> myAttractions = gson.fromJson(attractions, attractionsArrayList.getType());

        // Loop through our array list of arractions


        Log.d(myAttractions.toString(), "Whole shared prefs");
        for(Attraction activity : myAttractions){
           if(activity.getName().equals(attraction.getName()) ){
               ratingBar.setRating(activity.getRatingStar());
           }
        }

    }


    public void rateMe(View view){

        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Attraction.attractions);
        String attractions = sharedPref.getString("attractionRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Attraction>> attractionsArrayList = new TypeToken<ArrayList<Attraction>>(){};
        ArrayList<Attraction> myAttractions = gson.fromJson(attractions, attractionsArrayList.getType());

        attraction.setRatingStar(ratingBar.getRating());

        boolean attractionSet = false;

        for(Attraction existingAttraction : myAttractions){
            if(existingAttraction.getName().equals(attraction.getName())){
                int index = myAttractions.indexOf(existingAttraction);
                myAttractions.set(index, attraction);
                attractionSet = true;
            }
        }

        if (!attractionSet) {
            myAttractions.add(attraction);
        }




        Log.d(String.valueOf(myAttractions.size()), "Before save");

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("attractionRatingsList", gson.toJson(myAttractions));
        editor.apply();

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
//        Log.d(String.valueOf(ratingBar.getRating()), "star rating:");
//        Log.d(String.valueOf(attraction.getId()),"attraction id");


    }




}


