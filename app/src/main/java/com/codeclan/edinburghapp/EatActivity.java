package com.codeclan.edinburghapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EatActivity extends Activity {

    public static final String EXTRA_EATNO = "eatNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        int eatNo =(Integer)getIntent().getExtras().get(EXTRA_EATNO);
        Eat eat = Eat.eats[eatNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(eat.getImageResourceId());
        photo.setContentDescription(eat.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(eat.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(eat.getAddress());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(eat.getDescription());
    }
}
