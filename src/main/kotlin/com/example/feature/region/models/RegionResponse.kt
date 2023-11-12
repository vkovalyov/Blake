package com.example.feature.region.models

import org.bson.types.ObjectId

data class RegionResponse(
    val id: String,
    val name: String = "",
    val coordinates: List<RegionCoordinate> = emptyList()
)