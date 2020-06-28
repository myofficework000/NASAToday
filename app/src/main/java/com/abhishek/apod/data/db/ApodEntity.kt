package com.abhishek.apod.data.db
/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "apod")
data class ApodEntity(

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @field:SerializedName("date")
    val date: Date? = null,

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("media_type")
    val mediaType: String? = null,

    @field:SerializedName("hdurl")
    val hdurl: String? = null,

    @field:SerializedName("service_version")
    val serviceVersion: String? = null,

    @field:SerializedName("explanation")
    val explanation: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null
) : Parcelable