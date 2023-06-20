package com.lega.base.data.mappers

import com.lega.base.data.response.UserResponse
import com.lega.base.domain.models.User

fun UserResponse.mapToUser() = User(
    user = this.user ?: "",
    password = this.password?:"",
    email = this.email ?: "sin email",
    role = -1
)


