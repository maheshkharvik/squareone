package com.persons.finder.repository.model


import java.io.Serializable
import javax.persistence.*

@Entity

@Table(name = "locations")
data class LocationsEntity
(
        // Tip: Person's id can be used for this field
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long =0,
        @Column(name = "referenceId", unique = true, nullable = false)
        val referenceId: Long =0,
        @Column(name = "latitude", unique = false, nullable = false)
        val latitude: Double =0.00,
        @Column(name = "longitude", unique = false, nullable = false)
        val longitude: Double =0.00,
        ):Serializable


data class LocationResponse(

        val Id: Long,
        val referenceId: Long,
        val latitude: Double,
        val longitude: Double
)

fun LocationsEntity.toResponse()= LocationResponse(
        Id=id,
        referenceId=referenceId,
        latitude=latitude,
        longitude=longitude
)