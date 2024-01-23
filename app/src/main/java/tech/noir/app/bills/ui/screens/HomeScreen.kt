package tech.noir.app.bills.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tech.noir.app.bills.core.ui.theme.BillsTheme
import tech.noir.app.bills.navigation.presentation.components.BottomNavigation
import tech.noir.app.bills.ui.viewModel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel?, navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (refBottomNav) = createRefs()

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

        //TODO: Add lacking components + viewModel logic
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