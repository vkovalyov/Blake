package com.example.core.db

import com.example.feature.place.models.Place
import com.example.feature.place_photo.models.PlacePhoto
import com.example.feature.place_reference.models.PlaceReference
import com.example.feature.place_type.models.PlaceType
import com.example.feature.region.models.Region
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

const val mongoConnection : String = "";
class DataBaseImpl(private val dataBaseName: String) : Database {

    override val dbName: String
        get() = dataBaseName

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient(connectionString = mongoConnection).coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(dbName)

    override val userCollection: CoroutineCollection<User>
        get() = database.getCollection()

    override val regionCollection: CoroutineCollection<Region>
        get() = database.getCollection()

    override val placePhotoCollection: CoroutineCollection<PlacePhoto>
        get() = database.getCollection()

    override val placeReferenceCollection: CoroutineCollection<PlaceReference>
        get() = database.getCollection()

    override val placeTypeCollection: CoroutineCollection<PlaceType>
        get() = database.getCollection()

    override val placeCollection: CoroutineCollection<Place>
        get() = database.getCollection()


//    override val menuCollection: CoroutineCollection<MenuItem>
//        get() = database.getCollection()
//
//    override val orderCollection: CoroutineCollection<Order>
//        get() = database.getCollection()
}