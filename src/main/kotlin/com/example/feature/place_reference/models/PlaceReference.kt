package com.example.feature.place_reference.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PlaceReference(
    @BsonId
    val id: String = ObjectId().toString(),
    val placeId: String = ObjectId().toString(),
    val title: String,
    val referenceUrl: String,
)