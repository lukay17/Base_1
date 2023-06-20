package com.lega.base.core.di.presentation

import com.lega.base.core.di.IoDispatcher
import com.lega.m3kotlinmvvmapp.presentation.core.LoadingDelegate
import com.lega.m3kotlinmvvmapp.presentation.core.LoadingDelegateViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideEventsApp(@IoDispatcher workerScope: CoroutineScope): LoadingDelegateViewModel {
        return LoadingDelegate(workerScope)
    }
}
