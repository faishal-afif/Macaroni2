package com.example.macaroni.ui

import android.app.Application
import com.facebook.stetho.Stetho

class MenuApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }

}