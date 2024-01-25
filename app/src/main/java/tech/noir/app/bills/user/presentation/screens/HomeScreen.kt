package tech.noir.app.bills.user.presentation.screens

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.noir.app.bills.core.ui.theme.BillsTheme
import tech.noir.app.bills.navigation.presentation.components.BottomNavigation
import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.security.presentation.viewModel.AuthViewModel

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {

    val user = viewModel?.currentUser
    if (user == null) {
        navController.navigate("login")
        return
    }

    val authFlow = viewModel.loginFlow.collectAsState()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (refBottomNav, refUserInfo) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(refUserInfo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            when (val response = authFlow.value) {
                is Response.Failure -> {
                    val context = LocalContext.current
                    Toast.makeText(context, response.exception.message, Toast.LENGTH_LONG).show()
                }
                Response.Loading -> {
                    CircularProgressIndicator()
                }
                is Response.Success -> {
                    val firebaseUser = response.result
                    Text(text = firebaseUser.displayName ?: "No name")
                }
                else -> {
                    // Handle the case where authFlow.value is null
                }
            }
        }

        Box(
            modifier = Modifier
                .constrainAs(refBottomNav) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            BottomNavigation(navController)
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    BillsTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    BillsTheme {
        HomeScreen(null, rememberNavController())
    }
}