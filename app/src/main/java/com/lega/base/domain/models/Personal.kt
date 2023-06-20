package com.lega.base.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//data class Personal(val img: String, val name: String= "", val cargo: String, val estacion: String)
@Parcelize
data class Personal(val id: Int, val img :String, val nombres: String, val apellidos: String= "", val cargo: String, val estacion: String, val bp: String):
    Parcelable
