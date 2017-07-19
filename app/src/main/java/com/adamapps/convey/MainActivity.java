package com.adamapps.convey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter listAdapter;
    private String[] items = {"POST", "GET", "REPOST", "CARRY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView)findViewById(R.id.list_view);
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_container, R.id.list_item, items);

        mListView.setAdapter(listAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getBaseContext(), MapsActivity.class).putExtra("deliveryType",
                        listAdapter.getItem(i).toString()));
            }
        });
    }
}
