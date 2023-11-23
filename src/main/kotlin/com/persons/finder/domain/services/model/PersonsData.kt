
package com.persons.finder.domain.services

import com.persons.finder.presentation.PersonsDTO

data class PersonsData(
        // Tip: Person's id can be used for this field
        val name: String?,
        val distance: Double
)

{

    fun from(personsDto: PersonsDTO): PersonsData {
        return PersonsData(
                name = personsDto.name,
                distance = personsDto.distance,

        )
    }


}
