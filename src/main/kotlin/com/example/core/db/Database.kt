package com.example.core.db

import com.example.feature.place.models.Place
import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_type.models.PlaceType
import com.example.feature.region.models.Region
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase


interface Database {
    val dbName: String
    val mongoClient: CoroutineClient
    val database: CoroutineDatabase
    val userCollection: CoroutineCollection<User>
    val regionCollection: CoroutineCollection<Region>
    val placePhotoCollection: CoroutineCollection<PlacePhoto>
    val placeReferenceCollection: CoroutineCollection<PlaceReference>
    val placeTypeCollection: CoroutineCollection<PlaceType>
    val placeCollection: CoroutineCollection<Place>
}


@Serializable
class User {
    @SerialName("age")
    val age: Int? = null

    @SerialName("name")
    val name: String? = null
}

@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)