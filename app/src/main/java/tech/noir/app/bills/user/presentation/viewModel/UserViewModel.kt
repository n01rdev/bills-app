package tech.noir.app.bills.user.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.user.infrastructure.db.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _userDataFlow = MutableStateFlow<Response<UserData>?>(null)
    val userDataFlow: StateFlow<Response<UserData>?> = _userDataFlow

    init {
        loadHomeData()
    }

    private fun loadHomeData() = viewModelScope.launch {
        _userDataFlow.value = Response.Loading
        val result = repository.loadHomeData()
        _userDataFlow.value = result
    }
}