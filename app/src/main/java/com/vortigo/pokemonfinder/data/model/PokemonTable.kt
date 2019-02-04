package com.vortigo.pokemonfinder.data.model

import io.realm.RealmList
import io.realm.RealmObject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Representation table Pokemon
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
open class PokemonTable(
     var id: Int = 0,
     var abilities: RealmList<String>? = null,
     var detailPageURL: String? = "",
     var weight: Double? = Double.MIN_VALUE,
     var weakness: RealmList<String>? = null,
     var number: String? = "",
     var height: Int? = 0,
     var collectibles_slug: String? = "",
     var featured: String? = "",
     var slug: String? = "",
     var name: String? = "",
     var thumbnailAltText: String? = "",
     var thumbnailImage: String? = "",
     var type: RealmList<String>? = null
): RealmObject()
