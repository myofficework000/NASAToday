/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.di.module

import android.content.Context
import androidx.room.Room
import com.abhishek.apod.data.db.ApodDao
import com.abhishek.apod.data.db.ApodDb
import com.abhishek.apod.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApodDbModule {

    @Provides
    @Singleton
    fun provideApodDb(@ApplicationContext context: Context): ApodDb = Room
        .databaseBuilder(context, ApodDb::class.java, "apodapp.db")
        .build()

    @Provides
    @Singleton
    fun provideApodDao(apodDb: ApodDb): ApodDao = apodDb.ApodDao()
}
