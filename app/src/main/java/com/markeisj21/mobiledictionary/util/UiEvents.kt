package com.markeisj21.mobiledictionary.util

sealed class UiEvents{
    data class SnackBarEvent(val message: String): UiEvents()
}
