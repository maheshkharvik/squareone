package com.persons.finder.repository

import com.persons.finder.repository.model.LocationsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LocationsRepository : JpaRepository<LocationsEntity, Long>