package com.persons.finder.domain.services

import com.persons.finder.domain.services.model.PersonsData
import com.persons.finder.repository.LocationsRepository
import com.persons.finder.repository.PersonRepository
import com.persons.finder.repository.model.LocationsEntity
import com.persons.finder.repository.model.PersonsEntity
import com.persons.finder.repository.model.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.sqrt


@Service
class LocationsServiceImpl : LocationsService {
    @Autowired
    private val locationsRepository: LocationsRepository? = null
    @Autowired
    private val personRepository: PersonRepository? = null

    @Autowired
    private val personsService: PersonsService? = null


    override fun addLocation(location: LocationsEntity) : LocationsEntity = locationsRepository!!.save(location);


    override fun removeLocation(locationReferenceId: Long) {
        TODO("Not yet implemented")
    }

    override fun getAllLocations():List<LocationsEntity> {
      return  locationsRepository!!.findAll()
    }

  override fun findPersonNearestLocations(radiusInKm: Double, id: Long): MutableList<PersonsData>{

      val user= personsService!!.getPersonById(id);

      return getNearestPersons(user,radiusInKm);
    }

    /*
    * @user : Reference person
    *
    * */
    fun getNearestPersons(user: PersonsEntity, radiusInKm:Double) :MutableList<PersonsData>{

        val userLocation = user.locationId?.toResponse();
        val userLongitude= userLocation!!.longitude;
        val userLatitude= userLocation.latitude;
        val nearestPersonsList: MutableList<PersonsData> = mutableListOf()

        val persons= personRepository?.findAll();
        val iterator= persons?.listIterator();

        if (iterator != null) {
            while(iterator.hasNext()){
                val nextPerson=iterator.next();
                val nearestLocation= nextPerson.locationId

                val distance= calculateDistance(userLatitude,userLongitude, nearestLocation!!.latitude,nearestLocation.longitude)
                if(distance != 0.0 && distance<radiusInKm){
                    val userName= nextPerson.name;
                    val personData=  PersonsData(userName, distance) ;
                    nearestPersonsList.add(personData);
                }
            }
        }
        return  nearestPersonsList;
    }
    fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val EARTH_RADIUS= 6371;
        val lat1Rad = Math.toRadians(lat1)
        val lat2Rad = Math.toRadians(lat2)
        val lon1Rad = Math.toRadians(lon1)
        val lon2Rad = Math.toRadians(lon2)
        val x = (lon2Rad - lon1Rad) * kotlin.math.cos((lat1Rad + lat2Rad) / 2)
        val y = lat2Rad - lat1Rad
        return sqrt(x * x + y * y) * EARTH_RADIUS
    }


}