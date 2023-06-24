package com.lega.base.data.datasource.impl

import com.lega.base.data.api.ApiPersonal
import com.lega.base.data.datasource.PersonalDatasource
import com.lega.base.data.response.Persona
import com.lega.base.data.response.PersonalResponse
import com.lega.base.domain.models.Personal
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonalDatasourceImpl @Inject constructor(
    private val apiPersonal: ApiPersonal
): PersonalDatasource {

    override fun getListPersonal(): Flow<PersonalResponse> = flow {
        delay(2000)
        emit(apiPersonal.getListPersonal())
    }

    override fun getPersoanlId(userId: Int): Flow<Persona> =flow {
        delay(2000)
        emit(apiPersonal.getPersonalId(userId))
    }

    override fun deletePersonal(userId: Int): Flow<Persona> = flow {
        delay(2000)
        emit(apiPersonal.deletePersonal(userId))
    }

}