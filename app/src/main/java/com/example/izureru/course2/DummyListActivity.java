package com.example.izureru.course2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DummyListActivity extends AppCompatActivity {

    ArrayList<String> dummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_list);

        ListView lv = (ListView)findViewById(R.id.listView);

        setDummyData();
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummyData));
    }

    private void setDummyData() {
        for (int i = 0; i<10; i ++)
        {
            dummyData.add("element " + 1);
        }
    }

}
