package com.example.feature.place_photo.models

import org.bson.types.ObjectId

data class PlacePhotoResponse(
    val id: String,
    val placeId: String = ObjectId().toString(),
    val photoUrl: String,
)