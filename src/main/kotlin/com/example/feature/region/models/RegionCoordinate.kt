package com.example.feature.region.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegionCoordinate(
    @SerialName("lat")
    val lat : Double,
    @SerialName("lon")
    val lon : Double,
)