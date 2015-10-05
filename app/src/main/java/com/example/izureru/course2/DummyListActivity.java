package com.example.izureru.course2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DummyListActivity extends AppCompatActivity {

    ArrayList<Person> dummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_list);

        ListView lv = (ListView)findViewById(R.id.listView);

        setDummyData();
        lv.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, dummyData));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("TAG",  "Click" + dummyData.get(position));
            }
        });
    }

    private void setDummyData() {
        for (int i = 0; i<10; i ++)
        {
            Person p = new Person();
            p.setName("Fred Blogs the " + i + "st");
            p.setAddress(i + "Accacia Ave");
            p.setJob("On the dole");
            dummyData.add(p);
        }
    }

}
