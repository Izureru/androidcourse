package com.example.izureru.course2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DummyListActivity extends AppCompatActivity {

    ArrayList<Person> dummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_list);

        ListView lv = (ListView)findViewById(R.id.listView);

        setDummyData();
        lv.setAdapter(new ArrayAdapter<Person>(this, R.layout.custom_cell, R.id.textView5, dummyData)
        {
            @Override
            public View getView(int position, View cell, ViewGroup parent) {
                if (cell == null){
                    cell = getLayoutInflater().inflate(R.layout.custom_cell, parent, false);
                }
                TextView t = (TextView)cell.findViewById(R.id.textView5);
                ImageView iv = (ImageView)cell.findViewById(R.id.imageView3);

                Person p = dummyData.get(position);
                t.setText(p.getName());
                return cell;
            }
        });
//        lv.setAdapter(new ArrayAdapter<Person>(this, R.layout.custom_cell, R.id.textView5, dummyData));
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
