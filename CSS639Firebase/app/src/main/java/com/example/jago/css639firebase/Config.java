package com.example.jago.css639firebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by JaGo on 7/12/16.
 */
public class Config extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
