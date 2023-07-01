package com.lega.base.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//data class Personal(val img: String, val name: String= "", val cargo: String, val estacion: String)
@Parcelize
data class Personal(val id: Int,
                    val img :String,
                    val name: String = "",
                    val dni: String,
                    val nationality:String,
                    val organization:String,
                    val position: String,
                    val phone: String): Parcelable
