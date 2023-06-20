package com.lega.base.data.mappers

import com.google.gson.annotations.SerializedName
import com.lega.base.data.response.Persona
import com.lega.base.data.response.PersonalResponse
import com.lega.base.domain.models.Personal

fun PersonalResponse.matToPersonal() =
    results?.map {
        Personal(
            id = it?.id ?: 0,
            img = it?.img?.split("?")?.get(0)?:"",
            nombres = it?.nombres ?:"",
            apellidos = it?.apellidos  ?: "",
            cargo = it?.cargo ?:"",
            estacion = it?.estacion ?: "",
            bp = it?.bp ?:"",
        )
    }.orEmpty()

fun Persona.matToPersonalId() = Personal(
    id = this.id ?: -1,
    img =this.img ?: "",
    nombres = this?.nombres ?:"",
    apellidos = this?.apellidos?:"",
    cargo = this?.cargo ?:"",
    estacion = this?.estacion?: "",
    bp = this?.bp ?:""
)




