package com.example.feature.place_type.models

import org.bson.types.ObjectId

data class PlaceTypeResponse(
    val id: String = ObjectId().toString(),
    val name: String,
    val iconUrl: String,
)