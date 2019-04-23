package com.droidrank.sample;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userName,passWord;
    private String username,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.eduser);
        passWord = (EditText) findViewById(R.id.edpass);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        username = userName.getText().toString();
        password = passWord.getText().toString();

        if (userName.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"enter username ",Toast.LENGTH_SHORT).show();
        }
        else if (passWord.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"enter password ",Toast.LENGTH_SHORT).show();
        }else if (userName.getText().toString().isEmpty() || passWord.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"enter username & password",Toast.LENGTH_SHORT).show();
        } else if (!passWord.getText().toString().equals("AgiliZ12345")){
            Toast.makeText(MainActivity.this,"enter password is AgiliZ12345 ",Toast.LENGTH_SHORT).show();
        }else if(userName.getText().toString().length()>0 || passWord.getText().toString().equals("AgiliZ12345")) {
            Toast.makeText(MainActivity.this,"Login successfull ",Toast.LENGTH_SHORT).show();
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent(MainActivity.this, AlarmReceiver.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(MainActivity.this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND, 10);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

            Intent Homeintent = new Intent(MainActivity.this,Dashboard.class);
            startActivity(Homeintent);
            finish();
        }
    }
}
