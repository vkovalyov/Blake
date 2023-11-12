package com.example.feature.place_reference.models

import org.bson.types.ObjectId

data class PlaceReferenceResponse(
    val id: String,
    val placeId: String = ObjectId().toString(),
    val title: String,
    val referenceUrl: String,
)