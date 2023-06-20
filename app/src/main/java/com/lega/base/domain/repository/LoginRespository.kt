package com.lega.base.domain.repository

import com.lega.base.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRespository {
    fun logIn(userName:String, password:String): Flow<User>
}