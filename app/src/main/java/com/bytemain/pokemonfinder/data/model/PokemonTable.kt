package com.bytemain.pokemonfinder.data.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

/**
 * @author rorogarcete
 * @version 0.0.1
 * Representation table Pokemon
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
open class PokemonTable(
     @PrimaryKey var id: Int = 0,
     var detailPageURL: String = "",
     var weight: Double = Double.MIN_VALUE,
     var number: String = "",
     var height: Double = Double.MIN_VALUE,
     var collectibles_slug: String = "",
     var featured: String = "",
     var slug: String = "",
     @Index var name: String = "",
     var thumbnailAltText: String = "",
     var thumbnailImage: String = "",
     var type: RealmList<TypeTable> = RealmList()): RealmObject()
