package com.kotlin.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.mvvmdemo.R
import com.kotlin.mvvmdemo.model.ImageDO

class ImagesAdapter(val context: Context, val images: ArrayList<ImageDO>) :
    RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        Glide.with(context).load(images.get(position).getThumbnail()).into(holder.ivImage)
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivImage: ImageView = view.findViewById(R.id.ivImage)
    }

    override fun getItemCount(): Int {

        return images.size;

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        return ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_item, null));
    }

}