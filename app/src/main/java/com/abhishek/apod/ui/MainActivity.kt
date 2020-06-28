/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhishek.apod.R
import com.abhishek.apod.ui.detail.ApodDetailFragment
import com.abhishek.apod.ui.list.ApodListFragment
import com.abhishek.apod.ui.list.OnPictureSelectedListener

class MainActivity : AppCompatActivity(), OnPictureSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.add(R.id.container, ApodListFragment.newInstance())
            ft.commit()
        }
    }

    override fun onPictureSelected(position: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right,
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )
        fragmentTransaction.replace(
            R.id.container,
            ApodDetailFragment.newInstance(position)
        )
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
