package com.example.recyclevew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Model> movies=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();

        RecyclerView recyclerView=findViewById(R.id.recycleView);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false); recyclerView.setLayoutManager(layoutManager);
        RecycleViewAdapter adapter=new RecycleViewAdapter(this,movies);
        recyclerView.setAdapter(adapter);

    }
    private void setData()
    {
        movies.add(new Model(R.drawable.bloodborne_meme,"The meme"));
        movies.add(new Model(R.drawable.nice_crit_awesome_bleed,"The cultist"));
        movies.add(new Model(R.drawable.hornychina,"You are horny"));
    }
}