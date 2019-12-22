package com.example.android_list_view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.domain.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ListViewActivity extends Activity {

    List<Place> places = new ArrayList<Place>() {{
        add(new Place("Azores", "׳whale", "Whale watching"));
        add(new Place("Japan", "japanese", "Future technologies"));
        add(new Place("Ireland", "redhead", "Redhead people"));
        add(new Place("Philippines", "beach", "Perfect beaches"));
    }};

    List<String> names = new ArrayList<String>() {{
        add("Azores");
        add("Japan");
        add("Ireland");
        add("Philippines");
    }};


    ListView listView;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);

        if (Optional.ofNullable(listView).isPresent()) {
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
            listView.setAdapter(arrayAdapter);
        }

        Objects.requireNonNull(listView).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("PLACE", names.get(position));
            }
        });
    }
}
