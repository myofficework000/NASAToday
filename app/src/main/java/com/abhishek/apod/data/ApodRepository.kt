/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.data

import androidx.lifecycle.LiveData
import com.abhishek.apod.data.db.ApodDao
import com.abhishek.apod.data.db.ApodEntity
import com.abhishek.apod.data.network.ApodNetworkDataSource
import com.abhishek.apod.utilities.AppExecutors
import com.abhishek.apod.utilities.Utilities
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodRepository @Inject constructor(
    private val apodDao: ApodDao,
    private val apodNetworkDataSource: ApodNetworkDataSource,
    private val executors: AppExecutors
) {
    init {
        fetchPictureByDate()
        val apodLiveData = apodNetworkDataSource.getApodMutableLiveData()
        apodLiveData.observeForever {
            executors.diskIO().execute {
                apodDao.insertPicture(it)
            }
        }
    }

    fun fetchPictureByDate(date: String) {
        apodNetworkDataSource.fetchApodData(date)
    }

    fun getAllPictures(): LiveData<List<ApodEntity>> {
        return apodDao.getAllPictures()
    }

    private fun fetchPictureByDate() {
        val cal = Calendar.getInstance()
        executors.diskIO().execute {
            val apodEntity = apodDao.getPictureEntityByDate(
                Utilities.convertStringToDate(Utilities.getCurrentDate(cal))
            )
            if (apodEntity == null) fetchPictureByDate(Utilities.getCurrentDate(cal))
        }
    }
}