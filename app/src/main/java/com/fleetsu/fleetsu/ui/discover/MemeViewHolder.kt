package com.fleetsu.fleetsu.ui.discover

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fleetsu.fleetsu.extensions.*
import kohii.v1.exoplayer.Kohii
import kotlinx.android.synthetic.main.item_meme.view.*

class MemeViewHolder(
    private val memClickListener: MemeAdapter.OnMemeClickListener,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(meme: Meme, kohii: Kohii) {
        itemView.pvMeme.hide()
        itemView.ivMeme.hide()
        itemView.tvName.text = meme.memeUrl
        itemView.setOnClickListener {
            //userAdapterInterface.onUserClicked(user.id)
        }
        when (meme.type) {
            MemeType.Video -> {
                itemView.pvMeme.show()
                kohii.setUp(meme.memeUrl).bind(itemView.pvMeme)
            }
            MemeType.Photo -> {
                itemView.ivMeme.show()
                itemView.ivMeme.loadWithGlideRoundedCorners(meme.memeUrl, 16.dp)
            }
        }
    }

}
