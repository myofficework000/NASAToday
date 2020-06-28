/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.abhishek.apod.ApodApp
import com.abhishek.apod.R
import com.abhishek.apod.ui.list.ApodListViewModel
import timber.log.Timber
import javax.inject.Inject

class ApodDetailFragment : Fragment() {

    companion object {
        private const val PICTURE_POS = "picture_pos"
        private const val SAVE_VIEWPAGER_ITEM_POS = "save_vp_item_pos"

        fun newInstance(pos: Int) = ApodDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(PICTURE_POS, pos)
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var apodListViewModel: ApodListViewModel
    private lateinit var viewPager: ViewPager
    private lateinit var apodStatePagerAdapter: ApodStatePagerAdapter;
    private var position = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ApodApp.instance.getApodAppComponent().inject(this)
        val v = inflater.inflate(R.layout.fragment_apod_detail, container, false)
        initView(v)
        initialize()
        return v
    }

    private fun initView(view: View) {
        viewPager = view.findViewById(R.id.viewpager)
    }

    private fun initialize() {
        position = arguments?.getInt(PICTURE_POS) ?: 0
        apodStatePagerAdapter = ApodStatePagerAdapter(childFragmentManager, mutableListOf())
        viewPager.adapter = apodStatePagerAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        apodListViewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(ApodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        apodListViewModel.apodPictureList.observe(viewLifecycleOwner, Observer {
            for (apodEntity in it) Timber.e("${apodEntity.date}")
            apodStatePagerAdapter.setPictureData(it)
            viewPager.currentItem = position
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt(SAVE_VIEWPAGER_ITEM_POS)
            Timber.e("savedInstanceState %d", position)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.e("outState %d", viewPager.currentItem)
        outState.putInt(SAVE_VIEWPAGER_ITEM_POS, viewPager.currentItem)
    }
}
