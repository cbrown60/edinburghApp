package com.codeclan.edinburghapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SleepCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listSleeps = getListView();
        ArrayAdapter<Sleep> listAdapter = new ArrayAdapter<Sleep>(
                this,
                android.R.layout.simple_list_item_1,
                Sleep.sleeps
        );
        listSleeps.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(SleepCategoryActivity.this, SleepActivity.class);
        intent.putExtra(SleepActivity.EXTRA_SLEEPNO, (int) id);
        startActivity(intent);
    }
}
