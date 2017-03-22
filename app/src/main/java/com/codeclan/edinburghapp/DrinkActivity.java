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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKNO = "drinkNo";
    public static final String RATINGS = "ratings";
    public RatingBar ratingBar;
    public Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo =(Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        drink = Drink.drinks[drinkNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(drink.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());


        ratingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar

        // Sets up our shared preferences and gets info back
        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Drink.drinks);
        String drinks = sharedPref.getString("drinkRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Drink>> drinksArrayList = new TypeToken<ArrayList<Drink>>(){};
        ArrayList<Drink> myDrinks = gson.fromJson(drinks, drinksArrayList.getType());

        // Loop through our array list of arractions


        Log.d(myDrinks.toString(), "Whole shared prefs");
        for(Drink locations : myDrinks){
            if(locations.getName().equals(drink.getName()) ){
                ratingBar.setRating(locations.getRatingStar());
            }
        }

    }


    public void rateMe(View view){

        SharedPreferences sharedPref = getSharedPreferences(RATINGS, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String defaultValue = gson.toJson(Drink.drinks);
        String drinks = sharedPref.getString("drinkRatingsList", defaultValue);

        // Make an array of atrractions out of the string we got back from shared prefs
        TypeToken<ArrayList<Drink>> drinksArrayList = new TypeToken<ArrayList<Drink>>(){};
        ArrayList<Drink> myDrinks = gson.fromJson(drinks, drinksArrayList.getType());

        drink.setRatingStar(ratingBar.getRating());

        boolean drinkSet = false;

        for(Drink existingDrink : myDrinks){
            if(existingDrink.getName().equals(drink.getName())){
                int index = myDrinks.indexOf(existingDrink);
                myDrinks.set(index, drink);
                drinkSet = true;
            }
        }

        if (!drinkSet) {
            myDrinks.add(drink);
        }




        Log.d(String.valueOf(myDrinks.size()), "Before save");

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("drinkRatingsList", gson.toJson(myDrinks));

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
//        Log.d(String.valueOf(ratingBar.getRating()), "star rating:");
//        Log.d(String.valueOf(attraction.getId()),"attraction id");


    }




}



