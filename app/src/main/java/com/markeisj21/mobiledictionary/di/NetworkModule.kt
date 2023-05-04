package com.markeisj21.mobiledictionary.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.markeisj21.mobiledictionary.home.data.remote.DictionaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private fun loggingInterceptor(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
     fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(loggingInterceptor())
            .build()

    }
    @Provides
    @Singleton
    fun provideDictionaryApi(retrofit: Retrofit): DictionaryApi {
        return retrofit.create()
    }

}