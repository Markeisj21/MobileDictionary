package com.markeisj21.mobiledictionary.home.data.repository

import com.markeisj21.mobiledictionary.util.Resource
import com.markeisj21.mobiledictionary.home.data.remote.DefinitionResponseModel
import kotlinx.coroutines.flow.Flow

interface DefinitionRepository {
    suspend fun getDefinition(word: String): Flow<Resource<List<DefinitionResponseModel>>>
}