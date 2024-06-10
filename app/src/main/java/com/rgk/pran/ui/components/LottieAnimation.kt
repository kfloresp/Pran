package com.rgk.pran.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rgk.pran.R

@Composable
fun LottieAnimationComponent(@DrawableRes rawRes:Int, modifier: Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(rawRes))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)

    LottieAnimation(composition = composition, progress = {progress },modifier = modifier)
}

@Composable
fun LottieImageComponent(@DrawableRes rawRes:Int, modifier: Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(rawRes))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = 1)

    LottieAnimation(composition = composition, progress = {progress },modifier = modifier)
}

@Composable
fun LottieAnimationBackground() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.inside_out))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = {progress},
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(
                scaleX = 1.5f,
                scaleY = 1.5f
            )
    )
}