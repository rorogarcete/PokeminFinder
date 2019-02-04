package com.vortigo.pokemonfinder.domain.model

data class Pokemon (
    var id: Int,
    var abilities: Array<String>,
    var detailPageURL: String,
    var weight: Double,
    var weakness: Array<String>,
    var number: String,
    var height: Int,
    var collectibles_slug: String,
    var featured: String,
    var slug: String,
    var name: String,
    var thumbnailAltText: String,
    var thumbnailImage: String,
    var type: Array<Type>
)