package com.example.feature.region.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Region(
    @BsonId
    @SerialName("id")
    val id: String = ObjectId().toString(),
    @SerialName("name")
    val name: String,
    @SerialName("coordinates")
    val coordinates: List<RegionCoordinate>
)