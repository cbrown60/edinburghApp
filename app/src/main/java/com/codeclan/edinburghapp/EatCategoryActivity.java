package com.codeclan.edinburghapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EatCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listEats = getListView();
        ArrayAdapter<Eat> listAdapter = new ArrayAdapter<Eat>(
                this,
                android.R.layout.simple_list_item_1,
                Eat.eats
        );
        listEats.setAdapter(listAdapter);
    }
}
