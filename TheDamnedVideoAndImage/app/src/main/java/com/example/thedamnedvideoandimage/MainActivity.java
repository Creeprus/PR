package com.example.thedamnedvideoandimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button change;Button btnimg; ImageView img; int CAMERA_CAPTURE ;Button btnvideo; VideoView vid; public Bitmap thumbnailBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnimg=findViewById(R.id.butphoto); img=findViewById(R.id.imageorvideo); btnvideo=findViewById(R.id.butvideo); vid=findViewById(R.id.videoscreen); change=findViewById(R.id.butchangevideo);
        btnimg.setOnClickListener(view -> {
            try {
                {
                    Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(captureIntent,CAMERA_CAPTURE);
                }
            }
            catch (ActivityNotFoundException cant)
            {
                String errorMessage = "Camera is not supported on that device";
                Toast toast=Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT);
            }
        });

        change.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras=data.getExtras();
                thumbnailBitmap = (Bitmap) extras.get("data");
                img.setImageBitmap(thumbnailBitmap);

        }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        img.buildDrawingCache();
//        Parcelable bm = img.getDrawingCache();
        outState.putParcelable("savedImage", thumbnailBitmap);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       img.setImageBitmap(savedInstanceState.getParcelable("savedImage"));

    }

    }
