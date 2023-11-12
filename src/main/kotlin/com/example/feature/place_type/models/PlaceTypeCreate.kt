package com.example.feature.place_type.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class PlaceTypeCreate(
    @SerialName("name")
    val name: String,
    @SerialName("iconUrl")
    val iconUrl: String,
)
