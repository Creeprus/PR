package com.example.mpt_raspisanie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> ParaDay=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setData();


        RecyclerView recyclerView=findViewById(R.id.recycleView);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false); recyclerView.setLayoutManager(layoutManager);
        RecycleViewAdapter adapter=new RecycleViewAdapter(this,ParaDay);
        recyclerView.setAdapter(adapter);
    }
    private void setData()
    {
        ParaDay.add(new Model("Понедельник","Технология разработки программного обеспечения","","Технология разработки и защиты базы данных", "РМП","РПМ (Бушин)","ИСР ПО","","",""));
        ParaDay.add(new Model("Вторник","ПРАКТИКА","","ПРАКТИКА", "ПРАКТИКА","","ПРАКТИКА","","ПРАКТИКА","ПРАКТИКА"));
        ParaDay.add(new Model("Среда","ПРАКТИКА","","ПРАКТИКА", "ПРАКТИКА","","ПРАКТИКА","","ПРАКТИКА","ПРАКТИКА"));
        ParaDay.add(new Model("Четверг","Физ-ра","","РМП", "РПМ (Бушин)","","Системное программирование","","",""));
        ParaDay.add(new Model("Пятница","Технология разработки программного обеспечения","ИСР ПО","РПМ (Комаров)", "Иностранный язык","","Системное программирование","Технология разработки и защиты базы данных","",""));
    }
}