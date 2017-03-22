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

import java.util.ArrayList;

public class SleepActivity extends Activity {

    public static final String EXTRA_SLEEPNO = "sleepNo";
    public static final String RATINGS = "ratings";
    public RatingBar ratingBar;
    public Sleep sleep;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        int sleepNo =(Integer)getIntent().getExtras().get(EXTRA_SLEEPNO);
        sleep = Sleep.sleeps[sleepNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(sleep.getImageResourceId());
        photo.setContentDescription(sleep.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(sleep.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(sleep.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(sleep.getDescription());



        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar

        // Sets up our shared preferences and gets info back
        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Sleep.sleeps);
        String sleeps = sharedPref.getString("sleepRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Sleep>> sleepsArrayList = new TypeToken<ArrayList<Sleep>>(){};
        ArrayList<Sleep> mySleeps = gson.fromJson(sleeps, sleepsArrayList.getType());

        // Loop through our array list of arractions


        Log.d(mySleeps.toString(), "Whole shared prefs");
        for(Sleep locations : mySleeps){
            if(locations.getName().equals(sleep.getName()) ){
                ratingBar.setRating(locations.getRatingStar());
            }
        }

    }


    public void rateMe(View view){

        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Sleep.sleeps);
        String sleeps = sharedPref.getString("sleepRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Sleep>> sleepsArrayList = new TypeToken<ArrayList<Sleep>>(){};
        ArrayList<Sleep> mySleeps = gson.fromJson(sleeps, sleepsArrayList.getType());

        sleep.setRatingStar(ratingBar.getRating());

        Log.d("hello", "hello");
        boolean sleepSet = false;

        for(Sleep existingSleep : mySleeps){
            if(existingSleep.getName().equals(sleep.getName())){
                int index = mySleeps.indexOf(existingSleep);
                mySleeps.set(index, sleep);
                sleepSet = true;
            }
        }

        if (!sleepSet) {
            mySleeps.add(sleep);
        }




        Log.d(String.valueOf(mySleeps.size()), "Before save");

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sleepRatingsList", gson.toJson(mySleeps));

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
//        Log.d(String.valueOf(ratingBar.getRating()), "star rating:");
//        Log.d(String.valueOf(attraction.getId()),"attraction id");


    }



}

