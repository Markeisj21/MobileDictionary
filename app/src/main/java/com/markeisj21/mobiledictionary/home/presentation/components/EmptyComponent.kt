package com.markeisj21.mobiledictionary.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.markeisj21.mobiledictionary.R
import com.markeisj21.mobiledictionary.home.data.remote.DefinitionResponseModel

@Composable
fun EmptyComponent(
    isLoading: Boolean,
    definition: List<DefinitionResponseModel>?
) {
    if(!isLoading && definition.isNullOrEmpty()){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                EmptyAnimation()
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Sorry cant find definition",
                    fontFamily = FontFamily(Font(R.font.nunito_sans_light)),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}

@Composable
fun EmptyAnimation() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.not_found))

    LottieAnimation(
        composition = composition,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        iterations = LottieConstants.IterateForever
    )
}