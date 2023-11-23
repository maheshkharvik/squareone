package com.persons.finder.domain.services.model

import com.persons.finder.presentation.model.LocationDto
import com.persons.finder.repository.model.LocationsEntity

data class locationData (
    // Tip: Person's id can be used for this field
    val Id: Long,
    val referenceId: Long,
    val latitude: Double,
    val longitude: Double
)

{
    companion object ModelMapper {
        fun from(locationEntity: LocationsEntity): locationData {
            return locationData(
                    Id = locationEntity.id,
                    referenceId = locationEntity.referenceId,
                    latitude = locationEntity.latitude,
                    longitude = locationEntity.longitude,

                    )

        }}

   fun from(locationDto: LocationDto): locationData {
        return locationData(
                Id = locationDto.Id,
                referenceId = locationDto.referenceId,
                latitude = locationDto.latitude,
                longitude = locationDto.longitude,
                        )
    }


}