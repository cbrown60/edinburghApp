package com.codeclan.edinburghapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    @Override
    public void onListItemClick(ListView listView,
                                  View itemView,
                                  int position,
                                  long id){
        Intent intent = new Intent(EatCategoryActivity.this, EatActivity.class);
        intent.putExtra(EatActivity.EXTRA_EATNO, (int) id);
        startActivity(intent);
    }


}
