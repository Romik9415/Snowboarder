package com.fleetsu.fleetsu.ui.discover

import android.provider.MediaStore

data class Meme(
    val meme_id: String,
    val isLiked: Boolean?,
    val meme_url: String
//    val type: MemeType.Video
)

enum class MemeType {
    Video,
    Photo
}
