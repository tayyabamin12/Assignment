package com.upday.assignment.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upday.assignment.R
import com.upday.assignment.data.model.Data

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(dataSet: Data?, context: Context) {
        if (dataSet != null) {
//            itemView.txt_news_name.text = news.title
//            Picasso.get().load(news.image).into(itemView.img_news_banner)
            val imageView = itemView.findViewById<ImageView>(R.id.iv_image)
            Glide
                .with(context)
                .load(dataSet.assets.preview.url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_itemview, parent, false)
            return NewsViewHolder(view)
        }
    }
}