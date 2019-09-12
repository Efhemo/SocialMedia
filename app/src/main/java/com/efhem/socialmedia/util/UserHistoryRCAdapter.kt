package com.efhem.socialmedia.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.efhem.socialmedia.R
import com.efhem.socialmedia.model.Post
import com.efhem.socialmedia.util.Utils.getExtension
import com.efhem.socialmedia.util.Utils.resId
import kotlinx.android.synthetic.main.post_media_item.view.*

class UserHistoryRCAdapter :
    ListAdapter<Post, UserHistoryRCAdapter.ItemViewholder>(UserHistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_media_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserHistoryRCAdapter.ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Post) = with(itemView) {

            val extension = getExtension(item.mediaUrl)

            if (extension != null && extension == ".mp4") {
                val resId = resId("play_vegas_2", R.drawable::class.java)
                itemView.image.setImageResource(resId)
            } else {
                Glide.with(this).load(item.mediaUrl)
                    .apply(RequestOptions.placeholderOf(R.drawable.glide_placeholder))
                    .apply(RequestOptions.centerCropTransform())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(itemView.image)
            }

            setOnClickListener {
            }
        }
    }
}

class UserHistoryDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}