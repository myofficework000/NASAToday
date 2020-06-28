/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.abhishek.apod.data.db.ApodEntity

class ApodEntityDiffCallBack : DiffUtil.ItemCallback<ApodEntity>() {
    override fun areItemsTheSame(oldItem: ApodEntity, newItem: ApodEntity): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: ApodEntity, newItem: ApodEntity): Boolean {
        return oldItem == newItem
    }
}