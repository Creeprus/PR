package com.example.thedamnedvideoandimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {

    Button change;Button btnimg; ImageView img;   int VIDEO_CAPTURE;Button btnvideo; VideoView vid;Uri vidUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
       img=findViewById(R.id.imageorvideo); btnvideo=findViewById(R.id.butvideo); vid=findViewById(R.id.videoscreen); change=findViewById(R.id.butchangeimage);
        btnvideo.setOnClickListener(view -> {
            try {
                Intent captureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(captureIntent,VIDEO_CAPTURE);
            }
            catch (ActivityNotFoundException cant) {
                String errorMessage = "Camera is not supported on that device";
                Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            }

        });
        change.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras=data.getExtras();
                vidUri = data.getData();
                vid.setVideoURI(vidUri);
                vid.setZOrderOnTop(true);
                vid.start();
            }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        img.buildDrawingCache();
//        Parcelable bm = img.getDrawingCache();
        outState.putParcelable("savedVideo", vidUri);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        vid.setVideoURI(savedInstanceState.getParcelable("savedVideo"));

    }
    }

