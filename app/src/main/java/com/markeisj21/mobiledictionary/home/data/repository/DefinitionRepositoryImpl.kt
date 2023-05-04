package com.markeisj21.mobiledictionary.home.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.markeisj21.mobiledictionary.util.Resource
import com.markeisj21.mobiledictionary.di.IoDispatcher
import com.markeisj21.mobiledictionary.home.data.remote.DefinitionResponseModel
import com.markeisj21.mobiledictionary.home.data.remote.DictionaryApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefinitionRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : DefinitionRepository {
    override suspend fun getDefinition(word: String): Flow<Resource<List<DefinitionResponseModel>>> =
        flow {
            emit(Resource.Loading())

            when (val response = dictionaryApi.getDefinition(word = word)) {
                is NetworkResponse.Success -> {
                    val definitionResponse = response.body
                    emit(Resource.Success(data = definitionResponse))
                }
                is NetworkResponse.ServerError -> {
                    emit(
                        Resource.Error(
                            message = response.body?.message ?: "Try another word, please!"
                        )
                    )
                }
                is NetworkResponse.NetworkError ->{
                    emit(
                        Resource.Error(
                            message = "Please check your Internet Connection"
                        )
                    )
                }
                is NetworkResponse.UnknownError->{
                    emit(
                        Resource.Error(
                           message = "Unknown error occurred"
                        )
                    )
                }
            }
        }.flowOn(ioDispatcher)
}