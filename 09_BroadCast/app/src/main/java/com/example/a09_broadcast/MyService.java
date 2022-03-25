package com.example.a09_broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

class MyService extends Service {

    public MyService()
    {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder
    {
        MyService getService()
        {
            return MyService.this;
        }
    }

    IBinder binder = new LocalBinder();

    public int getNumber()
    {
        return 1;
    }


}
