package com.codeclan.edinburghapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AttractionCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listAttractions = getListView();
        ArrayAdapter<Attraction> listAdapter = new ArrayAdapter<Attraction>(
                this,
                android.R.layout.simple_list_item_1,
                Attraction.attractions
        );
        listAttractions.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(AttractionCategoryActivity.this, AttractionActivity.class);
        intent.putExtra(AttractionActivity.EXTRA_ATTRACTIONNO, (int) id);
        startActivity(intent);
    }
}

