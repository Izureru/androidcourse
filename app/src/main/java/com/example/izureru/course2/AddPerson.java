package com.example.izureru.course2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPerson extends AppCompatActivity {

    private EditText nameTV;
    private EditText addressTV;
    private EditText jobTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        nameTV = (EditText)findViewById(R.id.nameTV);
        addressTV = (EditText)findViewById(R.id.addressTV);
        jobTV = (EditText)findViewById(R.id.jobTV);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPerson();
            }
        });
    }

    private void addPerson() {
        Intent i = new Intent();
        i.putExtra("Name", nameTV.getText().toString());
        i.putExtra("Address", addressTV.getText().toString());
        i.putExtra("Job", jobTV.getText().toString());
        setResult(1, i);
        finish();
    }
}
