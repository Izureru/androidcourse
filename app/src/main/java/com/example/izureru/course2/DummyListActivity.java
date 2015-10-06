package com.example.izureru.course2;

import android.content.Intent;
import android.graphics.Color;
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
    private int number = 20;
    private ListView lv;
    private ArrayAdapter<Person> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_list);

        lv = (ListView)findViewById(R.id.listView);
        findViewById(R.id.addPersonButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDummyPerson();
            }
        });

        setDummyData();

        adapter = new ArrayAdapter<Person>(this, R.layout.custom_cell, R.id.textView5, dummyData)
        {
            class ViewHolder{
                TextView t;
                TextView details;
                ImageView iv;
            }

            @Override
            public View getView(int position, View cell, ViewGroup parent)
            {
                ViewHolder vh = null;
                if (cell == null){
                    cell = getLayoutInflater().inflate(R.layout.custom_cell, parent, false);
                    vh = new ViewHolder();
                    vh.t = (TextView)cell.findViewById(R.id.textView5);
                    vh.details = (TextView)cell.findViewById(R.id.textView3);
                    vh.iv = (ImageView)cell.findViewById(R.id.imageView3);
                    cell.setTag(vh);

                }
                else
                {
                    vh = (ViewHolder)cell.getTag();
                }

                Person p = dummyData.get(position);
                vh.t.setText(p.getName());
                vh.details.setText(p.getAddress());
                cell.setBackgroundColor((position%2 == 0) ? Color.GRAY: Color.GREEN);
                return cell;
            }
        };

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
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

    private void addDummyPerson(){
        Intent i = new Intent(this, AddPerson.class);
        startActivityForResult(i, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Person p = new Person();

        if (data != null) {
            p.setName(data.getStringExtra("Name"));
            p.setAddress(data.getStringExtra("Address"));
            p.setJob(data.getStringExtra("Job"));
            adapter.add(p);
        }
        else{
            Log.v("CRASHING :(","Error Adding Person");
        }
    }
}
