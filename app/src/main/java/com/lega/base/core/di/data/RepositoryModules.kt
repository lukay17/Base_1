package com.lega.m3kotlinmvvmapp.core.di.data

import com.lega.base.data.repository.LoginRespositoryImpl
import com.lega.base.data.repository.PersonalRepositoryImpl
import com.lega.base.domain.repository.LoginRespository
import com.lega.base.domain.repository.PersonalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {
    @Binds
    abstract fun bindinLoginRepository(impl: LoginRespositoryImpl): LoginRespository

    @Binds
    abstract fun bindinPersonalRepository(impl: PersonalRepositoryImpl): PersonalRepository
}