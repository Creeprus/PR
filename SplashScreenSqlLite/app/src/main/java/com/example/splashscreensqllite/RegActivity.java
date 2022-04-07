package com.example.splashscreensqllite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegActivity  extends AppCompatActivity {
EditText login,password;DataBaseHelper databaseHelper;
CheckBox check;
Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        databaseHelper=new DataBaseHelper(this);
        Intent intent_to_news=new Intent(this,NewsActivity.class);
        login=findViewById(R.id.LoginUser);
        password=findViewById(R.id.PasswordUser);
check=findViewById(R.id.roleBox);
        reg=findViewById(R.id.ButReg);
        reg.setOnClickListener(view -> {
            Boolean check_db;
            if (check.isChecked())
            {
                 check_db=databaseHelper.Insert_User(login.getText().toString(),password.getText().toString(),"Administrator");
            }
            else
            {
                check_db=databaseHelper.Insert_User(login.getText().toString(),password.getText().toString(),"User");
            }
            
            if (check_db)
            {
                Toast.makeText(getApplicationContext(),"The account is successfully registered",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(getApplicationContext(),"The account with the same login already exists",Toast.LENGTH_LONG).show();
            }
        });
    }
}
