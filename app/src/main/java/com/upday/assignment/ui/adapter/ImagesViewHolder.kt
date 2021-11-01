package com.upday.assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upday.assignment.R
import com.upday.assignment.data.model.Data

class ImagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(dataSet: Data?, context: Context) {
        if (dataSet != null) {
            val imageView = itemView.findViewById<ImageView>(R.id.iv_image)
            Glide
                .with(context)
                .load(dataSet.assets.preview.url)
                .placeholder(R.drawable.ic_image_background)
                .into(imageView)
        }
    }

    companion object {
        fun create(parent: ViewGroup): ImagesViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_itemview, parent, false)
            return ImagesViewHolder(view)
        }
    }
}