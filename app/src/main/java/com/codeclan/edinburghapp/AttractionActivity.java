package com.codeclan.edinburghapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class AttractionActivity extends Activity {
    public static String EXTRA_ATTRACTIONNO = "attractionNo";
    public RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        int attractionNo =(Integer)getIntent().getExtras().get(EXTRA_ATTRACTIONNO);
        Attraction attraction = Attraction.attractions[attractionNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(attraction.getImageResourceId());
        photo.setContentDescription(attraction.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(attraction.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(attraction.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(attraction.getDescription());

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }


    public void rateMe(View view){



        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
    }

}


