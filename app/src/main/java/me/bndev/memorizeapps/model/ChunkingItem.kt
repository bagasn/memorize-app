package me.bndev.memorizeapps.model

import androidx.annotation.ColorRes

class ChunkingItem {
    var id: ChunkingEnum? = null
    var title: String? = null
    var description: String? = null
    var color = 0

    constructor() {}
    constructor(
        id: ChunkingEnum?,
        title: String?,
        description: String?,
        @ColorRes color: Int
    ) {
        this.id = id
        this.title = title
        this.description = description
        this.color = color
    }

}