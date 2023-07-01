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
            name = it?.name ?:"",
            dni = it?.dni ?:"",
            nationality = it?.nationality  ?: "",
            organization = it?.organization ?:"",
            position = it?.position ?: "",
            phone = it?.phone ?:""
        )
    }.orEmpty()

fun Persona.matToPersonalId() = Personal(
    id = this.id ?: -1,
    img =this.img ?: "",
    name = this?.name ?:"",
    dni = this?.dni?:"",
    nationality = this?.nationality ?:"",
    organization = this?.organization?: "",
    position = this?.position ?:"",
    phone = this?.phone ?:""
)




