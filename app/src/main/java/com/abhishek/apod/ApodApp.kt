/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod

import android.app.Application
import com.facebook.stetho.Stetho
import com.abhishek.apod.di.module.ContextModule
import com.abhishek.apod.di.component.AppComponent
import com.abhishek.apod.di.component.DaggerAppComponent
import com.abhishek.apod.utilities.CustomDebugTree
import timber.log.Timber

class ApodApp : Application() {

    companion object {
        @JvmStatic
        lateinit var instance: ApodApp
            private set
    }

    private val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent.inject(this)
        initTimber()
        initStetho()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(CustomDebugTree())
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    fun getApodAppComponent(): AppComponent = appComponent
}