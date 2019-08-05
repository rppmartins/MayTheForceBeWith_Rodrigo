package com.example.rppma.maytheforcebewith_rodrigo;

import android.app.Application;

import com.example.rppma.maytheforcebewith_rodrigo.DataAccess.HttpRequests;

public class MTFBWRApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HttpRequests.init(getApplicationContext());
    }
}
