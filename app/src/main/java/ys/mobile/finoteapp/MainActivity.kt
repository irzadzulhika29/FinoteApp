package ys.mobile.finoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ys.mobile.finoteapp.navigation.AppNavHost
import ys.mobile.finoteapp.navigation.BottomNavBar
import ys.mobile.finoteapp.navigation.Screen
import ys.mobile.finoteapp.ui.theme.FinoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinoteApp()
        }
    }
}

@Composable
fun FinoteApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screen.Home.route, Screen.Insight.route, Screen.GoalTracker.route, Screen.Profile.route -> true
        else -> false
    }

    FinoteAppTheme {
        Scaffold(
            bottomBar = { if (showBottomBar) BottomNavBar(navController) }
        ) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
