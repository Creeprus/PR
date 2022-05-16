package com.example.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WidgetProvider extends android.appwidget.AppWidgetProvider{
    private static final String ACTION_WIDGET_RECEIVER = "APPWIDGET_ENABLED";
    String jokeString="oof";
    Button but;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
       for (int appWidgetId : appWidgetIds)
       {
           Intent intent =new Intent(context, MainActivity.class);

           RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.widget);
           PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
           views.setOnClickPendingIntent(R.id.WidgetButton,pendingIntent);

           appWidgetManager.updateAppWidget(appWidgetId, views);
       }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
// не робит вообще. Это одна из попыток
     //  final String action = intent.getAction();
        //if (ACTION_WIDGET_RECEIVER.equals(action)) {
            String pastjoke = jokeString;
            JokeLoader loader = new JokeLoader();
            loader.execute();
           // while (jokeString == pastjoke){ }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
            remoteViews.setTextViewText(R.id.JokeBox, jokeString);
            appWidgetManager.updateAppWidget(R.id.JokeBox, remoteViews);
       //}
        super.onReceive(context, intent);
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
public class JokeLoader extends AsyncTask<Void,Void,Void>
{
    String jokeString="";
    @Override
    protected Void doInBackground(Void... voids)
    {
        String jsonString = getJson("https://api.chucknorris.io/jokes/random");
        try
        {
            JSONObject jsonObject=new JSONObject(jsonString);
            jokeString=jsonObject.getString("value");

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



    }
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

    }

}


}
