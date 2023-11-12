package com.example.feature.place.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Place(
    @BsonId
    val id: String = ObjectId().toString(),
    val regionId: String = ObjectId().toString(),
    val placeTypeId: String = ObjectId().toString(),
    val previewPhotoId: String = ObjectId().toString(),
    val title: String,
    val description: String,
    val audioUrl: String,
    val lat: Double,
    val lon: Double,
)