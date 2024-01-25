package tech.noir.app.bills.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import tech.noir.app.bills.core.ui.theme.BillsTheme
import tech.noir.app.bills.navigation.application.AppNavHost
import tech.noir.app.bills.security.presentation.viewModel.AuthViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val authViewModel by viewModels<AuthViewModel>()
    private val userViewModel by viewModels<tech.noir.app.bills.user.presentation.viewModel.UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BillsTheme {
                AppNavHost(authViewModel, userViewModel)
            }
        }
    }
}