/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.di.module

import android.content.Context
import com.abhishek.apod.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private var context: Context) {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = context
}