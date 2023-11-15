package com.example.feature.region.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class RegionResponse(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String = "",
   // @SerialName("coordinates")
   // val coordinates: List<RegionCoordinate> = emptyList()
)