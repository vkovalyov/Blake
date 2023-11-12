package com.example.feature.place_reference.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class PlaceReferenceCreate(
    @SerialName("placeId")
    val placeId: String = ObjectId().toString(),
    @SerialName("title")
    val title: String,
    @SerialName("referenceUrl")
    val referenceUrl: String,
)