package com.example.zeeshan.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        //ADAPTER VIEW
        listView = (ListView) findViewById(R.id.ListView);

        //DATA SOURCE
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact("Name = " + (i + 1), "Phone = " + (i+(30.65000000) + 1));
            if (new Random().nextInt(2) == 0) {
                contact.setGender("Female");
            } else {
                contact.setGender("Male");
            }
            list.add(contact);
        }

        ContactAdapter adapter = new ContactAdapter(this,R.layout.contactlist,list);

        listView.setAdapter(adapter);
    }
}
