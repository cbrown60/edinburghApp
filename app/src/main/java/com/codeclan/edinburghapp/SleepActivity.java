package com.codeclan.edinburghapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SleepActivity extends Activity {

        public static final String EXTRA_SLEEPNO = "sleepNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        int sleepNo =(Integer)getIntent().getExtras().get(EXTRA_SLEEPNO);
        Sleep sleep = Sleep.sleeps[sleepNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(sleep.getImageResourceId());
        photo.setContentDescription(sleep.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(sleep.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(sleep.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(sleep.getDescription());


    }
}
