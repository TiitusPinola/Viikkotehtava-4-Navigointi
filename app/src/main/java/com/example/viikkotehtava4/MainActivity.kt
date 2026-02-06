package com.example.viikkotehtava4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viikkotehtava4.navigation.ROUTE_CALENDAR
import com.example.viikkotehtava4.navigation.ROUTE_HOME
import com.example.viikkotehtava4.navigation.ROUTE_SETTINGS
import com.example.viikkotehtava4.ui.theme.MyApplicationTheme
import com.example.viikkotehtava4.view.CalendarScreen
import com.example.viikkotehtava4.view.HomeScreen
import com.example.viikkotehtava4.view.SettingsScreen
import com.example.viikkotehtava4.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val taskViewModel: TaskViewModel = viewModel()
            val isDarkMode = taskViewModel.isDarkMode.collectAsState()

            MyApplicationTheme(darkTheme = isDarkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNav(taskViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNav(taskViewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(
                taskViewModel = taskViewModel,
                onGoToCalendar = { navController.navigate(ROUTE_CALENDAR) },
                onGoToSettings = { navController.navigate(ROUTE_SETTINGS) }
            )
        }

        composable(ROUTE_CALENDAR) {
            CalendarScreen(
                taskViewModel = taskViewModel,
                onBackToList = { navController.popBackStack() }
            )
        }

        composable(ROUTE_SETTINGS) {
            SettingsScreen(
                taskViewModel = taskViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
