package com.example.feature.place_photo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class PlacePhotoCreate(
    @SerialName("placeId")
    val placeId: String = ObjectId().toString(),
    @SerialName("photoUrl")
    val photoUrl: String,
)