package com.lega.base.data.repository

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.lega.base.data.datasource.LoginDatasource
import com.lega.base.data.mappers.mapToUser
import com.lega.base.data.response.UserResponse
import com.lega.base.domain.models.User
import com.lega.base.domain.repository.LoginRespository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource
) : LoginRespository {

    override fun logIn(username: String, password: String): Flow<User> =
        loginDatasource.logIng(username, password).map { it.mapToUser() }

}