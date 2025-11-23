package ys.mobile.finoteapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ys.mobile.finoteapp.ui.camera.CameraPlaceholderScreen
import ys.mobile.finoteapp.ui.home.HomeScreen
import ys.mobile.finoteapp.ui.common.PlaceholderScreen
import ys.mobile.finoteapp.ui.transaction.AddTransactionScreen

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Filled.Home)
    data object Insight : Screen("insight", "Insight", Icons.Filled.Lightbulb)
    data object GoalTracker : Screen("goal_tracker", "Goal", Icons.Filled.Flag)
    data object Profile : Screen("profile", "Profile", Icons.Filled.Person)
    data object AddTransaction : Screen("add_transaction", "Add Transaction", Icons.Filled.Home)
    data object CameraPlaceholder : Screen("camera_placeholder", "Camera", Icons.Filled.Home)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Insight,
    Screen.GoalTracker,
    Screen.Profile
)

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onAddTransactionClick = { navController.navigate(Screen.AddTransaction.route) }
            )
        }
        composable(Screen.Insight.route) {
            PlaceholderScreen(title = "Insight")
        }
        composable(Screen.GoalTracker.route) {
            PlaceholderScreen(title = "Goal Tracker")
        }
        composable(Screen.Profile.route) {
            PlaceholderScreen(title = "Profile")
        }
        composable(Screen.AddTransaction.route) {
            AddTransactionScreen(onBack = { navController.popBackStack() }, onScanReceipt = {
                navController.navigate(Screen.CameraPlaceholder.route)
            })
        }
        composable(Screen.CameraPlaceholder.route) {
            CameraPlaceholderScreen(onBack = { navController.popBackStack() })
        }
    }
}
