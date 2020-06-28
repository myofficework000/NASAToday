/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui.list

import androidx.lifecycle.ViewModel
import com.abhishek.apod.data.ApodRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodListViewModel @Inject constructor(private val apodRepository: ApodRepository) : ViewModel() {

    val apodPictureList = apodRepository.getAllPictures()

    fun fetchPictureByDate(date: String) = apodRepository.fetchPictureByDate(date)
}