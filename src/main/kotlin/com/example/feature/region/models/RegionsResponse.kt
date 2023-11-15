package com.example.feature.region.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId
@Serializable
data class RegionsResponse(
    @SerialName("count")
    val count: Long,
    @SerialName("data")
    val data : List<RegionResponse>
)