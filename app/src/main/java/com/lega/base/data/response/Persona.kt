package com.lega.base.data.response

import com.google.gson.annotations.SerializedName

data class Persona (

    @field:SerializedName("id_personal")
    val id: Int? = null,

    @field:SerializedName("img")
    val img: String? = null,

    @field:SerializedName("nombres")
    val nombres: String? = null,

    @field:SerializedName("apellidos")
    val apellidos: String? = null,

    @field:SerializedName("cargo")
    val cargo: String? = null,

    @field:SerializedName("nombre")
    val estacion: String? = null,

    @field:SerializedName("bp")
    val bp: String? = null
)