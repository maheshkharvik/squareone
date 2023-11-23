package com.persons.finder.data

data class Location(
    // Tip: Person's id can be used for this field
        val Id: Long,
        val referenceId: Long,
    val latitude: Double,
    val longitude: Double

)
