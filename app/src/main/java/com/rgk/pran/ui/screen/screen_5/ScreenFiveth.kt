package com.rgk.pran.ui.screen.screen_5

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.rgk.pran.R
import com.rgk.pran.ui.components.CustomButton
import com.rgk.pran.ui.components.CustomButtonOutline
import com.rgk.pran.ui.components.LottieAnimationBackground
import com.rgk.pran.ui.components.LottieAnimationComponent
import com.rgk.pran.ui.components.TypewriterTextComponent
import com.rgk.pran.ui.config.Utils
import com.rgk.pran.ui.config.Utils.MESSAGE_CEL
import com.rgk.pran.ui.config.Utils.NUMBER_CEL

@SuppressLint("ResourceType")
@Composable
fun ScreenFiveth(onBackClick:() -> Unit) {
    var showContent by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimationBackground()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.zIndex(1f)
        ) {

            LottieAnimationComponent(
                rawRes = R.raw.popcorn,
                modifier = Modifier.height(150.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            TypewriterTextComponent(
                Utils.QUOTE_PAGE_5,
                delayPerCharacter = 50L,
                modifier = Modifier.fillMaxWidth().padding(10.dp,10.dp),
                onFinish = { showContent = true })

            Spacer(modifier = Modifier.height(30.dp))
            val activity = (LocalContext.current as? Activity)
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(durationMillis = 500))
            ) {
                Column( horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomButton(onClick = {enviarWhatsapp(context)}) {
                        Text(Utils.BUTTON_PAGE_5)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomButtonOutline(onClick = {activity?.finish()}) {
                        Text(Utils.BUTTON_PAGE_6)
                    }
                }

            }

        }
    }
}

fun enviarWhatsapp(context: Context) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(
            String.format(
                "https://api.whatsapp.com/send?phone=%s&text=%s",
                NUMBER_CEL,
                MESSAGE_CEL
            )
        )
    )
    context.startActivity(intent)
}

