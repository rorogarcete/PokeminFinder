package com.vortigo.pokemonfinder.data.model

import io.realm.RealmObject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Representation table Type Pokemon
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
open class TypeTable(
    var name: String = "",
    var thumbnailImage: String = ""
): RealmObject()

