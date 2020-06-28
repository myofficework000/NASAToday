/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.di.component

import com.abhishek.apod.ApodApp
import com.abhishek.apod.di.module.ApodDbModule
import com.abhishek.apod.di.module.ContextModule
import com.abhishek.apod.di.module.RetrofitModule
import com.abhishek.apod.di.module.ViewModelModule
import com.abhishek.apod.ui.detail.ApodDetailFragment
import com.abhishek.apod.ui.list.ApodListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RetrofitModule::class, ApodDbModule::class, ContextModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(apodApp: ApodApp)
    fun inject(apodListFragment: ApodListFragment)
    fun inject(apodDetailFragment: ApodDetailFragment)
}