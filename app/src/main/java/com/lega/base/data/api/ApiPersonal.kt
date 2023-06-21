package com.lega.base.data.api

import com.lega.base.data.response.Persona
import com.lega.base.data.response.PersonalResponse
import com.lega.base.data.response.UserResponse
import com.lega.base.domain.models.Personal
import retrofit2.http.*

interface ApiPersonal {

    @GET("/latam-ec/oma/entrenamiento/personal/list")
    suspend fun getListPersonal(): PersonalResponse

    @GET("/latam-ec/oma/entrenamiento/personal/view/{id}")
    suspend fun getPersonalId(@Path("id")id:Int): Persona

    @POST("/latam-ec/oma/entrenamiento/personal/delete/{id}")
    suspend fun deletePersonal(@Path("id")id:Int):Persona



    /*@GET("/AndroidXAMPP/webServices/readusersGet.php")
    suspend fun getListPersonal(): PersonalResponse

    @GET("/AndroidXAMPP/webServices/readUserPost.php?id_user={id}")
    suspend fun getPersonalId(@Path("id")id:Int): Persona

    @POST("AndroidXAMPP/webServices/deleteUserGet.php?id_user={id}")
    suspend fun deletePersonal(@Path("id")id:Int):Persona*/
}
