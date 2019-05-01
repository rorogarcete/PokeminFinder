package com.bytemain.pokemonfinder.data.model

import io.realm.RealmObject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Representation table Trainer
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
open class TrainerTable(
    var name: String = "",
    var typePokemonFavorite: String = "",
    var typeImageUrl: String = ""
): RealmObject()