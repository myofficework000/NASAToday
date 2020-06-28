/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhishek.apod.di.ViewModelKey
import com.abhishek.apod.ui.ViewModelFactory
import com.abhishek.apod.ui.list.ApodListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ApodListViewModel::class)
    abstract fun apodListViewModel(viewModel: ApodListViewModel): ViewModel
}