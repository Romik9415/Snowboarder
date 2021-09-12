package com.fleetsu.fleetsu.ui.discover

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.extensions.dp
import com.fleetsu.fleetsu.extensions.hide
import com.fleetsu.fleetsu.extensions.loadWithGlideRoundedCorners
import com.fleetsu.fleetsu.extensions.show
import kohii.v1.exoplayer.Kohii
import kotlinx.android.synthetic.main.item_meme.view.*


class MemeViewHolder(
    private val memClickListener: MemeAdapter.OnMemeClickListener,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(meme: Meme, kohii: Kohii, userName: String) {
        itemView.pvMeme.hide()
        itemView.ivMeme.hide()
        itemView.tvName.text = userName
        itemView.tvShare.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL")
            i.putExtra(Intent.EXTRA_TEXT, meme.meme_url)
            startActivity(itemView.context, Intent.createChooser(i, "Share URL"), null)
        }
        itemView.tvLike.setOnClickListener {
            val q = (meme.isLiked ?: false)
            meme.isLiked = !q
            itemView.tvLike.imageTintList = if (meme.isLiked == true) {
                itemView.context.getColorStateList(R.color.colorPrimaryDark)
            } else {
                itemView.context.getColorStateList(R.color.colorOnSurface)
            }
        }
        when (MemeType.Video) {
            MemeType.Video -> {
                itemView.pvMeme.show()
                val q = kohii.setUp(meme.meme_url).bind(itemView.pvMeme)
                q
            }
            MemeType.Photo -> {
                itemView.ivMeme.show()
                itemView.ivMeme.loadWithGlideRoundedCorners(meme.meme_url, 16.dp)
            }
        }
    }

}
