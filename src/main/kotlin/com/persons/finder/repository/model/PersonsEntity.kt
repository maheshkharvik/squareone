package com.persons.finder.repository.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "persons")
data class PersonsEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name", unique = true, nullable = false)
    val name: String? = null,
    @OneToOne(cascade= arrayOf(CascadeType.ALL))
    @JoinColumn(name = "locationId", referencedColumnName="referenceId")
    val locationId: LocationsEntity?=null
) :Serializable

data class PersonsResponse(

        val Id: Long,
        val name: String,
        val locationId: LocationsEntity

)

fun PersonsEntity.toResponse()= name?.let {
    if (locationId != null) {
        PersonsResponse(
                Id=id,
                name= it,
                locationId=locationId
        )
    }
}



