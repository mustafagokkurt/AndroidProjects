package com.example.a09_asyncservice.data.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Controls {

    public static boolean InternetControl(ConnectivityManager cm)
    {
        NetworkInfo[] netInfos = cm.getAllNetworkInfo();

        for(NetworkInfo netInfo : netInfos)
        {
            if(netInfo.isConnected())
            {
                return true;
            }
        }

        return false;
    }
}
