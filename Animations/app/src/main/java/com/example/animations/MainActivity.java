package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView rottext,leftrighttext,fadetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftrighttext=findViewById(R.id.textrightandleft);
        rottext=findViewById(R.id.textrotation);
        fadetext=findViewById(R.id.textfade);
        final Animation animationRotateCenter = AnimationUtils.loadAnimation(
                this, R.anim.rotation);
        final Animation animationrightlight = AnimationUtils.loadAnimation(
                this, R.anim.lefttoright);
        final Animation animationfade = AnimationUtils.loadAnimation(
                this, R.anim.fade);
        rottext.startAnimation(animationRotateCenter);
        leftrighttext.startAnimation(animationrightlight);
        fadetext.startAnimation(animationfade);

    }
}