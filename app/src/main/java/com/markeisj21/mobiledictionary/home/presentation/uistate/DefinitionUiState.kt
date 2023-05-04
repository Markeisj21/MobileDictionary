package com.markeisj21.mobiledictionary.home.presentation.uistate

import com.markeisj21.mobiledictionary.home.data.remote.DefinitionResponseModel

data class DefinitionUiState(
    val definition :List<DefinitionResponseModel>? = null,
    val isLoading: Boolean = false,
    val error:String? = null
)