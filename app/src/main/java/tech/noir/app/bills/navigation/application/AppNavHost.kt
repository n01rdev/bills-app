package tech.noir.app.bills.navigation.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.noir.app.bills.navigation.domain.ROUTE_BILLS
import tech.noir.app.bills.navigation.domain.ROUTE_HOME
import tech.noir.app.bills.navigation.domain.ROUTE_LOGIN
import tech.noir.app.bills.navigation.domain.ROUTE_PROFILE
import tech.noir.app.bills.navigation.domain.ROUTE_REGISTER
import tech.noir.app.bills.navigation.domain.ROUTE_SCAN
import tech.noir.app.bills.ui.screens.HomeScreen
import tech.noir.app.bills.security.presentation.screens.LoginScreen
import tech.noir.app.bills.security.presentation.screens.RegisterScreen
import tech.noir.app.bills.security.presentation.viewModel.AuthViewModel
import tech.noir.app.bills.ui.viewModel.HomeViewModel

@Composable
fun AppNavHost(
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel?,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(authViewModel, navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(authViewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(homeViewModel, navController)
        }
        composable(ROUTE_BILLS) {
            //BillsScreen(homeViewModel, navController)
        }
        composable(ROUTE_SCAN) {
            //ScanScreen(homeViewModel, navController)
        }
        composable(ROUTE_PROFILE) {
            //ProfileScreen(homeViewModel, navController)
        }
    }
}