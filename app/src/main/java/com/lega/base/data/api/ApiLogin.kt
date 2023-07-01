package com.lega.base.data.api

import com.lega.base.data.response.UserResponse
import retrofit2.http.*

interface ApiLogin {

    //funciono
    //@GET("/latam-ec/login/intro/{username}/{password}")
    //suspend fun logInUser(@Path("username")username:String, @Path("password") password:String):UserResponse

    //funciono
    @FormUrlEncoded
    @POST("/login/intro/")
    suspend fun logInUser(
        @FieldMap params:Map<String, String>
    ): UserResponse


    /*@FormUrlEncoded
    @POST("/login/registre")
    suspend fun registerUser(
        @FieldMap params:Map<String, String>
    ): UserResponse*/
}