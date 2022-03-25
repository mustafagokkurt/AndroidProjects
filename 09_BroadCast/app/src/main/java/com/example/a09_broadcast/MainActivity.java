package com.example.a09_broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Start Service
//        Intent is = new Intent(this, MyService.class);
//        startService(is);
//
//        Intent ib = new Intent(this, MyService.class);
//        bindService(ib, new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//                MyService.LocalBinder binder = (MyService.LocalBinder)iBinder;
//                MyService myService = binder.getService();
//                myService.getNumber();
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName componentName) {
//
//            }
//        }, Context.BIND_AUTO_CREATE);

        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        SmsReceiver r = new SmsReceiver();
        registerReceiver(r, filter);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 1);

        //BroadCAst

        IntentFilter filter1 = new IntentFilter("com.example.a09_broadcast");
        MyReceiver my = new MyReceiver();
        registerReceiver(my, filter1);

        Intent iy = new Intent("com.example.a09_broadcast");
        sendBroadcast(iy);
    }
}