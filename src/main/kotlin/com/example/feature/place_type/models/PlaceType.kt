package com.example.feature.place_type.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


data class PlaceType(
    @BsonId
    val id: String = ObjectId().toString(),
    val name: String,
    val iconUrl: String,
)