package com.persons.finder.domain.services
import com.persons.finder.domain.services.model.PersonsData
import com.persons.finder.repository.model.LocationsEntity


interface LocationsService {
    fun addLocation(location: LocationsEntity): LocationsEntity
    fun removeLocation(locationReferenceId: Long)
    fun findPersonNearestLocations(radiusInKm: Double, id: Long):MutableList<PersonsData>
     fun getAllLocations():List<LocationsEntity>
}