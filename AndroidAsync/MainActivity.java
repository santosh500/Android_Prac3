package com.example.santo_000.jsonparsingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    String JSON_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getJSON(View view)
    {
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<String, Void, String>
    {
        String json_url;

        @Override
        protected void onPreExecute() {

           json_url ="http://people.eecs.ku.edu/~pcharles/Android/JSON_example/json_get_data.php";
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_String = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(JSON_String+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(result);
                JSON_String = result;
        }
    }

    public void parseJSON(View view)
    {
        if(JSON_String==null)
        {
            Toast.makeText(getApplicationContext(),"First Get JSON",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data",JSON_String);
            startActivity(intent);
        }
    }

}
