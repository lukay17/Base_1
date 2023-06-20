package com.lega.base.data.datasource

import com.lega.base.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun logIng(user: String, pass: String): Flow<UserResponse>
}