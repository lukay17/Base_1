package com.lega.base.data.datasource.impl

import com.lega.base.data.api.ApiLogin
import com.lega.base.data.datasource.LoginDatasource
import com.lega.base.data.response.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(
 private val apiLogin: ApiLogin
): LoginDatasource {

    override fun logIng(user:String, password:String): Flow<UserResponse>  = flow {
        delay(2000)
        emit(apiLogin.logInUser(mapOf("username" to user, "password" to password )))
        //emit(apiLogin.logInUser(user, password ))
    }
}