package com.fleetsu.fleetsu.ui.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.fleetsu.fleetsu.R
import kohii.v1.exoplayer.Kohii

class MemeAdapter(
    private val memClickListener: OnMemeClickListener,
    private val kohii: Kohii
) :
    ListAdapter<Meme, MemeViewHolder>(MemeDiff) {

    object MemeDiff : DiffUtil.ItemCallback<Meme>() {

        override fun areItemsTheSame(oldItem: Meme, newItem: Meme) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: Meme, newItem: Meme) =
            oldItem.memeUrl == newItem.memeUrl

    }

    interface OnMemeClickListener {
        fun onLikeClicked(id: Long, checked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_meme, parent, false)
        return MemeViewHolder(memClickListener, view)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.bind(getItem(position), kohii)
    }
}

