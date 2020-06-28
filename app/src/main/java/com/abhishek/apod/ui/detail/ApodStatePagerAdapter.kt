/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.abhishek.apod.data.db.ApodEntity

class ApodStatePagerAdapter(
    fragmentManager: FragmentManager,
    private var apodList: List<ApodEntity>
) : FragmentStatePagerAdapter(fragmentManager) {

    fun setPictureData(apodList: List<ApodEntity>) {
        this.apodList = apodList
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment = ApodFragment.newInstance(apodList[position])

    override fun getCount(): Int = apodList.size
}