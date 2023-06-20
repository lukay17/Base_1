package com.lega.base.domain.repository

import com.lega.base.domain.models.Personal
import kotlinx.coroutines.flow.Flow

interface PersonalRepository {
    fun getListPersonal(): Flow<List<Personal>>
    fun getPersoanlId(userId:Int): Flow<Personal>
    fun deletePersonal(userId:Int): Flow<Personal>
}