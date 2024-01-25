package tech.noir.app.bills.user.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.noir.app.bills.core.ui.theme.BillsTheme
import tech.noir.app.bills.navigation.presentation.components.BottomNavigation
import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.user.domain.model.User
import tech.noir.app.bills.user.presentation.viewModel.UserViewModel

@Composable
fun HomeScreen(viewModel: UserViewModel?, navController: NavHostController) {
    val userDataFlow = viewModel?.userDataFlow?.collectAsState()

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
            when (val response = userDataFlow?.value) {
                is Response.Loading -> {
                    //TODO: Show loading indicator
                }
                is Response.Success -> {
                    val user = response.result as? User
                    if (user != null) {
                        Text(text = "User ID: ${user.id}")
                        //TODO: Display other user data as needed
                    }
                }
                is Response.Failure -> {
                    //TODO: Handle failure
                }
                null -> {
                    //TODO: Handle null case
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