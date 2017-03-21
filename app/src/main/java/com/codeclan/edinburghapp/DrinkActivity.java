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




}



