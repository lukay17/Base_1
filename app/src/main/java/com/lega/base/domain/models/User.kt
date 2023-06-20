package com.lega.base.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val user:String, val password:String, val email:String, val role:Int): Parcelable
