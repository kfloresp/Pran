package com.rgk.pran.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rgk.pran.ui.screen.screen_1.ScreenFirst
import com.rgk.pran.ui.screen.screen_2.ScreenSecond
import com.rgk.pran.ui.screen.screen_3.ScreenThird
import com.rgk.pran.ui.screen.screen_4.ScreenFourth
import com.rgk.pran.ui.screen.screen_5.ScreenFiveth
import com.rgk.pran.ui.screen.screen_6.ScreenSixth

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "screen_first") {
        composable("screen_first") {
            ScreenFirst(
                onNextClick = {
                    navController.navigate("screen_second")
                }
            )
        }
        composable("screen_second") {
            ScreenSecond(
                onNextClick = {
                    navController.navigate("screen_third")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable("screen_third") {
            ScreenThird(
                onNextClick = {
                    navController.navigate("screen_fourth")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable("screen_fourth") {
            ScreenFourth(
                onYesClick = {
                    navController.navigate("screen_fiveth")
                },
                onNoClick = {
                    navController.navigate("screen_sixth")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable("screen_fiveth") {
            ScreenFiveth(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable("screen_sixth") {
            ScreenSixth(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}