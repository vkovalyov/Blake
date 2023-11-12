package com.example.feature.region.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Region(
    @BsonId
    val id: String = ObjectId().toString(),
    val name: String,
    val coordinates: List<RegionCoordinate>
)