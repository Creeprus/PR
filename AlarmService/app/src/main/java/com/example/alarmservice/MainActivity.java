package com.example.alarmservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView editSeconds;
Button btnStartTimer;Button setTime;
    Calendar dateTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTime=findViewById(R.id.btnTime);
        TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateTime.set(Calendar.MINUTE, minute);
                editSeconds.setText(DateUtils.formatDateTime(getApplicationContext(),
                        dateTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
            }
        };
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, dateTime.get(Calendar.HOUR_OF_DAY),
                        dateTime.get(Calendar.MINUTE), true).show();
            }
        });
        editSeconds=findViewById(R.id.editSeconds);
        btnStartTimer=findViewById(R.id.btnStartTimer);
        btnStartTimer.setOnClickListener(view ->{
           // int seconds = Integer.parseInt(editSeconds.getText().toString());
            Intent intent=new Intent(MainActivity.this,Alarm.class);
            AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime.getTimeInMillis(),
                    PendingIntent.getBroadcast(getApplicationContext(),0,intent,0));

        });
    }
}