package com.codeclan.edinburghapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

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


    }

}
