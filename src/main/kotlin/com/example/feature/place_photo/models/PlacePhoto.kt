package com.example.feature.place_photo.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PlacePhoto(
    @BsonId
    val id: String = ObjectId().toString(),
    val placeId: String = ObjectId().toString(),
    val photoUrl: String,
)