package com.lega.base.domain.usecase

import com.lega.base.core.base.FlowUseCase
import com.lega.base.core.di.IoDispatcher
import com.lega.base.domain.models.Personal
import com.lega.base.domain.models.User
import com.lega.base.domain.repository.PersonalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddPersonalUseCase  @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val personalRespository: PersonalRepository
): FlowUseCase<AddPersonalUseCase.Params, Personal>(dispatcher) {

    override fun execute(params: Params): Flow<Personal> =
        personalRespository.deletePersonal(params.userId)

    data class Params(val userId:Int)
}