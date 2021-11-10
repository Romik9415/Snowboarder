package com.regram.ai.ui.discover

data class Meme(
    val meme_id: String,
    var isLiked: Boolean?,
    val meme_url: String
//    val type: MemeType.Video
)

enum class MemeType {
    Video,
    Photo
}
