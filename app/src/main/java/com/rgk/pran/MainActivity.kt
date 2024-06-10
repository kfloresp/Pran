package com.rgk.pran

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.rgk.pran.ui.components.NavGraph
import com.rgk.pran.ui.theme.PranTheme
import java.io.IOException

class MainActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PranTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
        startBackgroundMusic()
    }
    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }

    private fun startBackgroundMusic() {
        try {
            val assetFileDescriptor: AssetFileDescriptor = resources.openRawResourceFd(R.raw.inside_out_main_theme)
            mediaPlayer = MediaPlayer()
            mediaPlayer?.setDataSource(assetFileDescriptor.fileDescriptor, assetFileDescriptor.startOffset, assetFileDescriptor.length)
            mediaPlayer?.isLooping = true
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}



