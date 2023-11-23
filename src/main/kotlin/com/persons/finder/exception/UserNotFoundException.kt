package com.persons.finder.exception

import org.springframework.http.HttpStatus

class UserNotFoundException (val statuscode:HttpStatus,val reason:String) :Exception()
