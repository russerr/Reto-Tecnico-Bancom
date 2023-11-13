package com.russerdev.retotecnicobancom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.russerdev.retotecnicobancom.navigation.homeModuleGraph
import com.russerdev.retotecnicobancom.navigation.onboardingModuleGraph
import com.russerdev.retotecnicobancom.ui.theme.RetoTecnicoBancomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            RetoTecnicoBancomTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = viewModel.route) {
                    onboardingModuleGraph(navController)
                    homeModuleGraph(navController)
                }
            }
        }
    }
}