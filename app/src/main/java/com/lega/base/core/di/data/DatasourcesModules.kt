package com.lega.m3kotlinmvvmapp.core.di.data

import com.lega.base.data.datasource.LoginDatasource
import com.lega.base.data.datasource.PersonalDatasource
import com.lega.base.data.datasource.impl.LoginDatasourceImpl
import com.lega.base.data.datasource.impl.PersonalDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourcesModules {

    @Binds
    abstract fun bindingLoginDatasource(loginDatasourImpl: LoginDatasourceImpl): LoginDatasource

    @Binds
    abstract fun bindingPersonalDatasource(impl: PersonalDatasourceImpl): PersonalDatasource
}