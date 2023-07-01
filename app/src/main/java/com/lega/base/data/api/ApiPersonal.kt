package com.lega.base.data.api

import com.lega.base.data.response.Persona
import com.lega.base.data.response.PersonalResponse
import com.lega.base.data.response.UserResponse
import com.lega.base.domain.models.Personal
import retrofit2.http.*

interface ApiPersonal {

    @GET("/personal/control/list")
    suspend fun getListPersonal(): PersonalResponse

    @GET("/personal/control/views/{id}")
    suspend fun getPersonalId(@Path("id")id:Int): Persona

    @POST("/personal/control/delet/{id}")
    suspend fun deletePersonal(@Path("id")id:Int):Persona

}
