package com.example.android_list_view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.Island;
import com.example.IslandAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListViewActivity extends Activity {

    List<Island> islands = new ArrayList<Island>() {{
        add(new Island("Azores", "׳azores_islands", "Whale watching"));
        add(new Island("Japan", "japan", "Future technologies"));
        add(new Island("Ireland", "ireland", "Redhead people"));
        add(new Island("Philippines", "philippines", "Perfect beaches"));
        add(new Island("Sri-Lanka", "sri_lanka", "Surfing"));
    }};

    ListView listView;
    IslandAdapter islandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);

        Optional.ofNullable(listView).ifPresent(view -> {

            islandAdapter = new IslandAdapter(getApplicationContext(), R.layout.island_view, islands);
            listView.setAdapter(islandAdapter);

            listView.setOnItemClickListener((parent, view1, position, id) ->
                    Log.v("PLACE", islands.get(position).getName()));

        });
    }
}
