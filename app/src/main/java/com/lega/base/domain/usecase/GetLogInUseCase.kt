package com.lega.base.domain.usecase

import com.lega.base.core.base.FlowUseCase
import com.lega.base.core.di.IoDispatcher
import com.lega.base.domain.models.User
import com.lega.base.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRespository: LoginRespository
): FlowUseCase<GetLogInUseCase.Params, User>(dispatcher) {

    override fun execute(params: Params): Flow<User> =
        loginRespository.logIn(params.username,params.password)

    data class Params(val username:String, val password:String)
}