package com.example.cards.cards

import java.io.Serializable

data class CardData(
    val id: String = "",
    val imageId: Int = 0,
    val imageUrl: String? = null,
    val title: String = "",
    val descriptionShort: String = "",
    val descriptionLong: String = "",
    var isLiked: Boolean = false
)