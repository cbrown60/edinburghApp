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

public class EatActivity extends Activity {
    public static final String RATINGS = "ratings";
    public RatingBar ratingBar;
    public Eat eat;
    public static final String EXTRA_EATNO = "eatNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        int eatNo =(Integer)getIntent().getExtras().get(EXTRA_EATNO);
        eat = Eat.eats[eatNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(eat.getImageResourceId());
        photo.setContentDescription(eat.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(eat.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(eat.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(eat.getDescription());



        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar

        // Sets up our shared preferences and gets info back
        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Eat.eats);
        String eats = sharedPref.getString("eatRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Eat>> eatsArrayList = new TypeToken<ArrayList<Eat>>(){};
        ArrayList<Eat> myEats = gson.fromJson(eats, eatsArrayList.getType());

        // Loop through our array list of arractions




        for(Eat venues : myEats){

            if(venues.getName().equals(eat.getName()) ){
                ratingBar.setRating(venues.getRatingStar());

            }
        }

    }


    public void rateMe(View view){

        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Eat.eats);
        String eats = sharedPref.getString("eatRatingsList", defaultValue);
        Log.d("here","here");
        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Eat>> eatsArrayList = new TypeToken<ArrayList<Eat>>(){};
        ArrayList<Eat> myEats = gson.fromJson(eats, eatsArrayList.getType());

        eat.setRatingStar(ratingBar.getRating());
        Log.d("made it here","made it here");
        boolean eatSet = false;

        for(Eat existingEat : myEats){
            if(existingEat.getName().equals(eat.getName())){
                int index = myEats.indexOf(existingEat);
                myEats.set(index, eat);
                eatSet = true;

            }
        }

        if (!eatSet) {
            myEats.add(eat);
        }




        Log.d(String.valueOf(myEats.size()), "Before save");

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("eatRatingsList", gson.toJson(myEats));
        editor.apply();

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
//        Log.d(String.valueOf(ratingBar.getRating()), "star rating:");
//        Log.d(String.valueOf(attraction.getId()),"attraction id");


    }


}
