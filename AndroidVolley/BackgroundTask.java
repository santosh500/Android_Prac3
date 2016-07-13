package com.example.santo_000.volleydemo2;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by santo_000 on 7/12/2016.
 */
public class BackgroundTask
{
    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    String json_url = "http://people.eecs.ku.edu/~pcharles/Android/Android_2/weird.php";

    public BackgroundTask(Context context)
    {
        this.context = context;
    }

    public ArrayList<Contact> getList()
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, (String)null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count =0;
                        while (count < response.length())
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Contact contact = new Contact(jsonObject.getString("id"),jsonObject.getString("user_id"),jsonObject.getString("type"));
                                arrayList.add(contact);
                                System.out.print(jsonObject.getString("id"));
                                System.out.print(jsonObject.getString("user_id"));
                                System.out.print(jsonObject.getString("type"));
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,"Error..", Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });

        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);
        return arrayList;
    }
}
