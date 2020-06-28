/*
 * Copyright 2019 Sudhir Khanger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.abhishek.apod.data.network

import androidx.lifecycle.MutableLiveData
import com.abhishek.apod.data.db.ApodEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodNetworkDataSource @Inject constructor(
    private val apodService: ApodService
) {

    private val apodMutableLiveData = MutableLiveData<ApodEntity>()

    fun getApodMutableLiveData() = apodMutableLiveData

    fun fetchApodData(date: String) {
        Timber.e("data fetched for data %s", date)
        val apodService = apodService.getPictureOfTheDay(date)
        apodService.enqueue(object : Callback<ApodEntity> {
            override fun onResponse(call: Call<ApodEntity>, response: Response<ApodEntity>) {
                if (response.isSuccessful && response.body() != null) {
                    if (response.body()?.mediaType == "image")
                        apodMutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ApodEntity>, t: Throwable) {
                Timber.e(t, "onFailure caught")
            }
        })
    }
}