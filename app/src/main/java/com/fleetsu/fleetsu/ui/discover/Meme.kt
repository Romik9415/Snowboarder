package com.fleetsu.fleetsu.ui.discover

data class Meme(
    val id: Long,
    val isLiked: Boolean,
    val memeUrl: String,
    val type: MemeType
)

enum class MemeType {
    Video,
    Photo
}
