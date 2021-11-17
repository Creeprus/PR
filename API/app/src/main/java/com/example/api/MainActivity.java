package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
TextView txt_id;TextView txt_joke;TextView txt_url;TextView txt_created; TextView txt_iconurl;TextView updated_at;
Button btn;

String jokeString="";
String url_joke="";
String created_joke="";
String updated_joke="";
String icon_joke="";
String id_joke="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_id=findViewById(R.id.txtId);
        txt_created=findViewById(R.id.txtCreatedAt);
        txt_joke=findViewById(R.id.txtJoke);
        txt_url=findViewById(R.id.txtUrl);
        txt_iconurl=findViewById(R.id.txtIconUrl);
        updated_at=findViewById(R.id.UpdatedAt);
        btn=findViewById(R.id.btnClick);

        btn.setOnClickListener(view->new JokeLoader().execute());
    }
    private class JokeLoader extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            String jsonString = getJson("https://api.chucknorris.io/jokes/random");
            //String jsonString = getJson("https://localhost:5001/api/API/1"); // не мог завести api с проекта Михайлина из-за localhost
            try
                {
                    JSONObject jsonObject=new JSONObject(jsonString);
                    jokeString=jsonObject.getString("value");
                    id_joke=jsonObject.getString("id");
                    icon_joke=jsonObject.getString("icon_url");
                    updated_joke=jsonObject.getString("updated_at");
                    url_joke=jsonObject.getString("url");
                    created_joke=jsonObject.getString("created_at");
                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }
            return null;
        }
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
          //  jokeString="";

            txt_id.setText("Loading...");
            txt_created.setText("Loading...");
            txt_joke.setText("Loading...");
            txt_url.setText("Loading...");
            txt_iconurl.setText("Loading...");
            updated_at.setText("Loading...");

        }
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
           // if(jokeString.equals(""))
            {
                //txt.setText((jokeString));
                txt_id.setText(id_joke);
                txt_created.setText(created_joke);
                txt_joke.setText(jokeString);
                txt_url.setText(url_joke);
                txt_iconurl.setText(icon_joke);
                updated_at.setText(updated_joke);
            }
        }
    }
    private String getJson(String link)
    {
        String data="";
        try
            {
                URL url=new URL(link);
                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
                if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    BufferedReader r =new BufferedReader(new InputStreamReader((urlConnection.getInputStream()),"utf-8"));
                    data=r.readLine();
                    urlConnection.disconnect();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        return data;
    }

}