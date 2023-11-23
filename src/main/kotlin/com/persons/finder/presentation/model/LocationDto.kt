package com.persons.finder.presentation

import com.persons.finder.domain.services.locationData

data class LocationDto (
        val Id: Long,
        val referenceId: Long,
        val latitude: Double,
        val longitude: Double
    ) {
        companion object ModelMapper {
            fun from(locationData: locationData): LocationDto {
                return LocationDto(
                        Id = locationData.Id,
                        referenceId = locationData.referenceId,
                        latitude = locationData.latitude,
                        longitude = locationData.longitude,

                )
            }
        }
    }

