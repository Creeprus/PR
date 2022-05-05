package com.example.splashscreensqllite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {
    Button authBut;
    EditText login,password;DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        dataBaseHelper=new DataBaseHelper(this);
        authBut=findViewById(R.id.ButAuth);
        login=findViewById(R.id.LoginUserAuth);
        password=findViewById(R.id.PasswordUserAuth);
        Intent intent_admin=new Intent(this,AdminActivity.class);
        Intent intent_user=new Intent(this,NewsActivity.class);
    authBut.setOnClickListener(view -> {
        Cursor r= dataBaseHelper.Select_Role(login.getText().toString(),password.getText().toString());
        String role="";StringBuilder buffer=new StringBuilder();
        while (r.moveToNext())
        {
            role=r.getString(0);

        }
      //  Toast.makeText(getApplicationContext(),role,Toast.LENGTH_LONG).show();
        if(role.equals("Administrator"))
        {
            startActivity(intent_admin);
        }
        if(role.equals("User"))
        {
            startActivity(intent_user);
        }
    });
    }
}
