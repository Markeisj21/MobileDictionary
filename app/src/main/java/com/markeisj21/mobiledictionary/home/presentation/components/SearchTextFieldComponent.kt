package com.markeisj21.mobiledictionary.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import com.markeisj21.mobiledictionary.ui.theme.Shapes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextFieldComponent(
    setWordToBeSearched: (String) -> Unit,
    searchWord: () -> Unit,
    typedWord: String
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = typedWord, onValueChange = { wordEntered ->
            setWordToBeSearched(wordEntered)
        }, modifier = Modifier
            .fillMaxWidth(),
        placeholder = {
            Text(text = "Search Definition")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
        },
        trailingIcon = {
            if (typedWord.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Outlined.Clear,
                    contentDescription = "Clear Icon",
                    modifier = Modifier.clickable {
                        setWordToBeSearched("")
                    }
                )
            }
        },
        shape = Shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0XFFEBE7E7),
            unfocusedIndicatorColor = Color(0XFFEBE7E7),
            focusedIndicatorColor = Color(0XFF4C7AF2)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                searchWord()
                keyboardController?.hide()
                focusManager.clearFocus()

            }
        )
    )
}