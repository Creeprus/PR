package com.example.splashscreensqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button reg,auth,list;
DataBaseHelper h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent_reg =new Intent(this,RegActivity.class);
        Intent intent_auth =new Intent(this,AuthActivity.class);
        h=new DataBaseHelper(this);
        reg=findViewById(R.id.regBut);
        auth=findViewById(R.id.authBut);
        list=findViewById(R.id.listBut);
        reg.setOnClickListener(view ->{
        startActivity(intent_reg);
        });
        auth.setOnClickListener(view ->{
            startActivity(intent_auth);
        });
        list.setOnClickListener(view -> {
            Cursor r=h.getData();
            StringBuilder buffer=new StringBuilder();
            while (r.moveToNext())
            {
                buffer.append("Login: ").append(r.getString(0)).append("\n");
                buffer.append("Role: ").append(r.getString(2)).append("\n");
                buffer.append("\n");
            }
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("List of Users");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }
}