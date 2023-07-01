package com.lega.base.data.datasource

import com.lega.base.data.response.UserResponse
import com.lega.base.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun logIng(user: String, pass: String): Flow<UserResponse>
}