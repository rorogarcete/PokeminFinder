package com.vortigo.pokemonfinder.models

/**
 * @author rorogarcete
 * @version 0.0.1
 * Data class for Pokemon model
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
data class Pokemon (
    var id: Int,
    //var abilities: Array<String>,
    var detailPageURL: String,
    var weight: Double,
    //var weakness: Array<String>,
    var number: String,
    var height: Double,
    var collectibles_slug: String,
    var featured: String,
    var slug: String,
    var name: String,
    var thumbnailAltText: String,
    var thumbnailImage: String,
    var type: List<Type>
)