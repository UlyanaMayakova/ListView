package com.example.listview;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String TITLE = "title";
    private final static String SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.list_view);

        List<Map<String, String>> list = prepareContent();
        BaseAdapter adapter = createAdapter(list);
        listView.setAdapter(adapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> list) {
        String[] from = {TITLE, SUBTITLE};
        int[] to = {R.id.text, R.id.text_length};
        return new SimpleAdapter(this, list, R.layout.list_item, from, to);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> list = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");

        for (String s : arrayContent) {
            Map<String, String> map = new HashMap<>();
            map.put(TITLE, s);
            map.put(SUBTITLE, s.length() + "");
            list.add(map);
        }

        return list;
    }
}