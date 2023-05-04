package com.markeisj21.mobiledictionary.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.markeisj21.mobiledictionary.R

@Composable
fun PronunciationComponent(word: String, phonetic: String) {
    Column {
        Text(
            text = word,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.nunito_sans_extrabold))
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = phonetic,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
            color = Color(0XFF4C7AF2)
        )
    }


}