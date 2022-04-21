package com.example.splashscreensqllite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewsEditActivity extends AppCompatActivity {
    Button add,edit,delete;
    EditText title,content;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiity_editnews);
        dataBaseHelper=new DataBaseHelper(this);
        title=findViewById(R.id.titlenews);
        content=findViewById(R.id.contentnews);
        add=findViewById(R.id.AddNews);
        edit=findViewById(R.id.EditNews);
        delete=findViewById(R.id.DeleteNews);
        add.setOnClickListener(view -> {
            Boolean check_db;
            check_db=dataBaseHelper.Insert_News(title.getText().toString(),content.getText().toString());
            if (check_db)
            {
                Toast.makeText(getApplicationContext(),"News successfully added",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(getApplicationContext(),"The news with the same title already exists",Toast.LENGTH_LONG).show();
            }
        });
        edit.setOnClickListener(view -> {
            Boolean check_db;
            check_db=dataBaseHelper.Update_News(title.getText().toString(),content.getText().toString());
            if (check_db)
            {
                Toast.makeText(getApplicationContext(),"News successfully edited",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(getApplicationContext(),"News with the following title don't exists",Toast.LENGTH_LONG).show();
            }
        });
        delete.setOnClickListener(view -> {
            Boolean check_db;
            check_db=dataBaseHelper.Delete_News(title.getText().toString());
            if (check_db)
            {
                Toast.makeText(getApplicationContext(),"News successfully deleted",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(getApplicationContext(),"News with the following title don't exists",Toast.LENGTH_LONG).show();
            }
        });
    }
}
