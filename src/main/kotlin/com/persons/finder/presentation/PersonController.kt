package com.persons.finder.presentation

import com.persons.finder.domain.services.LocationsService
import com.persons.finder.domain.services.PersonsService
import com.persons.finder.presentation.model.PersonsDTO
import com.persons.finder.repository.model.LocationsEntity
import com.persons.finder.repository.model.PersonsEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/persons")
class PersonController @Autowired constructor() {

    @Autowired
    private val personsService: PersonsService? = null

    @Autowired
    private val locationsService: LocationsService? = null

    /*
    * POST API to create a 'person'
    *
    * */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@Validated @RequestBody payload: PersonsEntity): PersonsEntity = personsService!!.save(payload)

    /*
       PUT API to update/create someone's location using latitude and longitude
    */
    @PutMapping("/createLocation")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveLocation(@Validated @RequestBody payload: LocationsEntity): LocationsEntity = locationsService!!.addLocation(payload)

    @GetMapping("/getLocations")
    @ResponseBody
    fun getAllLocations( ): List<LocationsEntity> {
        return locationsService!!.getAllLocations()
    }
    /*
    GET API to retrieve a person or persons name using their ids
    */

    @GetMapping("/getUser/{id}")
    @ResponseBody
    fun getUserById( @PathVariable id: Long ): PersonsEntity {
        return personsService!!.getPersonById(id);
    }

    /*
    GET API to retrieve people around query location with a radius in KM, Use query param for radius. Extra challenge: Return list ordered by distance to each person.
    */
    @GetMapping("/getClosestLocations/{id}")
    @ResponseBody
    fun getClosesetLocations(@RequestParam radius: Double,@PathVariable id: Long ): List<PersonsDTO>  {
        val personsList=locationsService!!.findPersonNearestLocations(radius,id);
        val nearestPersonsList: MutableList<PersonsDTO> = mutableListOf()
        val iterator= personsList.listIterator();

       while (iterator.hasNext()){
           val persondata=iterator.next();
           val personDTO = PersonsDTO.from(persondata)
           nearestPersonsList.add(personDTO);
       }
        return nearestPersonsList;

    }

}