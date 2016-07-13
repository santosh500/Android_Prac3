package com.example.santo_000.jsonparsingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String JSON_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView) findViewById(R.id.listview);

        contactAdapter = new ContactAdapter(this,R.layout.row_layout);
        listView.setAdapter(contactAdapter);
        JSON_String = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(JSON_String);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count=0;
            String first_name, last_name, email;
            while(count < jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                first_name = JO.getString("first_name");
                last_name = JO.getString("last_name");
                email = JO.getString("email");

                Contacts contacts = new Contacts(first_name, last_name, email);
                contactAdapter.add(contacts);
                count++;


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
