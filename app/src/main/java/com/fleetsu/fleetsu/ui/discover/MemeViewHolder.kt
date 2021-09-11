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
        itemView.tvName.text = meme.meme_url
        itemView.setOnClickListener {
            //userAdapterInterface.onUserClicked(user.id)
        }
        when (MemeType.Video) {
            MemeType.Video -> {
                itemView.pvMeme.show()
                kohii.setUp(meme.meme_url).bind(itemView.pvMeme)
            }
            MemeType.Photo -> {
                itemView.ivMeme.show()
                itemView.ivMeme.loadWithGlideRoundedCorners(meme.meme_url, 16.dp)
            }
        }
    }

}
