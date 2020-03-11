package com.jc.appalumno

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Alumno {
    var id:String?=null
    var email:String?=null
    var password:String?=null
    var edad:Int?=null
}