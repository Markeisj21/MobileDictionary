package com.markeisj21.mobiledictionary.di

import com.markeisj21.mobiledictionary.home.data.remote.DictionaryApi
import com.markeisj21.mobiledictionary.home.data.repository.DefinitionRepository
import com.markeisj21.mobiledictionary.home.data.repository.DefinitionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDefinitionRepository(
        dictionaryApi: DictionaryApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): DefinitionRepository{
        return DefinitionRepositoryImpl(
            dictionaryApi = dictionaryApi,
            ioDispatcher = ioDispatcher
        )
    }

}