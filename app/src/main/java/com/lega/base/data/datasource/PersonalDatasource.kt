package com.lega.base.data.datasource

import com.lega.base.data.response.Persona
import com.lega.base.data.response.PersonalResponse
import kotlinx.coroutines.flow.Flow

interface PersonalDatasource {
    fun getListPersonal(): Flow<PersonalResponse>
    fun getPersoanlId(userId:Int): Flow<Persona>
    fun deletePersonal(userId:Int): Flow<Persona>
}
