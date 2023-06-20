package com.lega.base.data.repository

import com.lega.base.data.datasource.PersonalDatasource
import com.lega.base.data.mappers.matToPersonal
import com.lega.base.data.mappers.matToPersonalId
import com.lega.base.data.response.Persona
import com.lega.base.domain.models.Personal
import com.lega.base.domain.repository.PersonalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonalRepositoryImpl @Inject constructor(
    private val datasource: PersonalDatasource,
) : PersonalRepository {

    override fun getListPersonal(): Flow<List<Personal>> {
        return datasource.getListPersonal()
            .map {
                it.matToPersonal()
            }
    }

    override fun getPersoanlId(userId: Int): Flow<Personal> =
        datasource.getPersoanlId(userId).map { it.matToPersonalId()}

    override fun deletePersonal(userId: Int): Flow<Personal> =
       datasource.deletePersonal(userId).map { it.matToPersonalId()}

}