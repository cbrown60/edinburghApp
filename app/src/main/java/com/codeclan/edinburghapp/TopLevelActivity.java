package com.codeclan.edinburghapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class TopLevelActivity extends Activity {
//implements OnMapReadyCallback
//    GoogleMap mgoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);


//        if(googleServiecsAvailable()){
//            Toast.makeText(this, "Perfect", Toast.LENGTH_SHORT).show();

//            initMap();
//        } else {
//
//        }

//        sMapFragment = MapFragment.newInstance();

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listView,
                                    View v,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }

                if (position == 1){
                    Intent intent = new Intent(TopLevelActivity.this, EatCategoryActivity.class);
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(TopLevelActivity.this, SleepCategoryActivity.class);
                    startActivity(intent);
                }

                if (position == 3) {
                    Intent intent = new Intent(TopLevelActivity.this, AttractionCategoryActivity.class);
                    startActivity(intent);
                }

            }
        };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);


//        sMapFragment.getMapAsync(this);
//
//
    }

//    private void initMap() {
//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//
//    public boolean googleServiecsAvailable() {
//        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
//        int isAvailble = api.isGooglePlayServicesAvailable(this);
//        if(isAvailble == ConnectionResult.SUCCESS){
//            return true;
//        }else if (api.isUserResolvableError(isAvailble)){
//            Dialog dialog = api.getErrorDialog(this, isAvailble, 0);
//            dialog.show();
//        }else{
//            Toast.makeText(this, "cant connect to play services", Toast.LENGTH_LONG).show();
//        }
//        return false;
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mgoogleMap = googleMap;
//    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//    }



}
