package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
private DatabaseReference database;private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_EMAIL_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$_%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,20}$");
public static boolean checkEmailForValidity(String email) {
        Matcher mathcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        return mathcher.find();
    }
    public static boolean checkPasswordForValidity(String password) {
        Matcher mathcher = VALID_EMAIL_PASSWORD_REGEX.matcher(password);
        return mathcher.find();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editPhone = findViewById(R.id.phone);
        EditText editMail = findViewById(R.id.email);
        EditText editPassword = findViewById(R.id.password);
        EditText editPasswordcheck = findViewById(R.id.passwordcheck);
        Button btn = findViewById(R.id.reg);

        btn.setOnClickListener(view ->{
            String phone=editPhone.getText().toString();
            String email=editMail.getText().toString();
            String password=editPassword.getText().toString();
            String passwordcheck=editPasswordcheck.getText().toString();

            {

                   if(checkPasswordForValidity(password)&& checkEmailForValidity(email))
                    {
                    database= FirebaseDatabase.getInstance("https://fir-4ee9c-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Roles");
                    User user=new User(phone,email,password);

                    database.child(phone).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            editMail.getText().clear();
                            editPhone.getText().clear();
                            editPassword.getText().clear();
                            editPasswordcheck.getText().clear();
                            Toast.makeText(getApplicationContext(),"DATA ADDED",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Error!",Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }

        });


    }
}