package com.example.feature.region.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RegionCreate(
    @SerialName("name")
    val name: String?,
    //@SerialName("coordinates")
   // val coordinates: List<RegionCoordinate>
)