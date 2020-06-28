/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */

package com.abhishek.apod.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface ApodDao {

    @Query("SELECT * FROM apod")
    fun getAllPictures(): LiveData<List<ApodEntity>>

    @Query("SELECT * FROM apod WHERE date = :date")
    fun getPictureLiveDataByDate(date: Date): LiveData<ApodEntity>

    @Query("SELECT * FROM apod WHERE date = :date")
    fun getPictureEntityByDate(date: Date): ApodEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(apodEntity: ApodEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePicture(apodEntity: ApodEntity)
}