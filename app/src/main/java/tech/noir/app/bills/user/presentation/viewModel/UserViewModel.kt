package tech.noir.app.bills.user.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.user.application.service.UserService
import tech.noir.app.bills.user.domain.model.User
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userService: UserService,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _userDataFlow = MutableStateFlow<Response<User>?>(null)
    val userDataFlow: StateFlow<Response<User>?> = _userDataFlow

    init {
        loadHomeData()
    }

    private fun loadHomeData() = viewModelScope.launch {
        _userDataFlow.value = Response.Loading
        val uuid = firebaseAuth.currentUser?.uid
        if (uuid != null) {
            val userResponse = userService.getUserData(uuid)
            if (userResponse is Response.Success) {
                _userDataFlow.value = Response.Success(userResponse.result)
            } else if (userResponse is Response.Failure) {
                _userDataFlow.value = Response.Failure(userResponse.exception)
            }
        } else {
            _userDataFlow.value = Response.Failure(Exception("User not authenticated"))
        }
    }
}