/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.abhishek.apod.R
import com.abhishek.apod.data.db.ApodEntity
import com.abhishek.apod.utilities.Utilities

class ApodListAdapter(private val onPictureClick: (Int) -> Unit) :
    ListAdapter<ApodEntity, ApodListAdapter.ApodListViewHolder>(ApodEntityDiffCallBack()) {

    class ApodListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val apodIv: ImageView = view.findViewById(R.id.apod_list_iv)
        val apodTv: TextView = view.findViewById(R.id.apod_list_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_apod, parent, false)
        return ApodListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApodListViewHolder, position: Int) {
        getItem(position).let { apodEntity ->
            with(holder) {

                Picasso.get()
                    .load(apodEntity.hdurl)
                    .fit()
                    .centerCrop()
                    .noFade()
                    .placeholder(holder.itemView.resources.getDrawable(R.drawable.ic_image_white_24dp, null))
                    .error(holder.itemView.resources.getDrawable(R.drawable.ic_broken_image_white_24dp, null))
                    .into(this.apodIv)

                apodTv.text = Utilities.convertDateFormat(apodEntity.date)
                itemView.setOnClickListener { onPictureClick(position) }
            }
        }
    }
}