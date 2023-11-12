package com.example.feature.place.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class PlaceCreate(
    @SerialName("regionId")
    val regionId: String = ObjectId().toString(),
    @SerialName("placeTypeId")
    val placeTypeId: String = ObjectId().toString(),
    @SerialName("previewPhotoId")
    val previewPhotoId: String = ObjectId().toString(),
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("audioUrl")
    val audioUrl: String,
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double,
)