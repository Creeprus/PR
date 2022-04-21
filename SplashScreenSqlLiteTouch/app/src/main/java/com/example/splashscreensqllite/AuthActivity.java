package com.example.splashscreensqllite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class AuthActivity extends AppCompatActivity {
    Button authBut, scanBut;
    EditText login,password;DataBaseHelper dataBaseHelper;
    private BiometricPrompt biometricPrompt;
    private Executor executor;
    private BiometricPrompt.PromptInfo promptInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        dataBaseHelper=new DataBaseHelper(this);
        authBut=findViewById(R.id.ButAuth);
        login=findViewById(R.id.LoginUserAuth);
        password=findViewById(R.id.PasswordUserAuth);
        scanBut=findViewById(R.id.ButScanAuth);
        executor= ContextCompat.getMainExecutor(this);
        Intent intent_admin=new Intent(this,AdminActivity.class);
        Intent intent_user=new Intent(this,NewsActivity.class);
        biometricPrompt=new BiometricPrompt(AuthActivity.this,executor,new BiometricPrompt.AuthenticationCallback(){
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Log.e("ErrorAuth",errString.toString());
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Log.e("FailedAuth","Scan Failed");
            }


            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(AuthActivity.this, "Successful authorization", Toast.LENGTH_SHORT).show();
                startActivity(intent_user);
            }
        });
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
        promptInfo=new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Authorization")
                .setSubtitle("Scan your finger")
                .setNegativeButtonText("Cancel")
                .build();
        scanBut.setOnClickListener(view ->{
            biometricPrompt.authenticate(promptInfo);
        });
    }
}
