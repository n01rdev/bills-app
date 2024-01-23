package tech.noir.app.bills.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.security.infrastructure.db.repository.HomeRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _homeDataFlow = MutableStateFlow<Response<HomeData>?>(null)
    val homeDataFlow: StateFlow<Response<HomeData>?> = _homeDataFlow

    init {
        loadHomeData()
    }

    private fun loadHomeData() = viewModelScope.launch {
        _homeDataFlow.value = Response.Loading
        val result = repository.loadHomeData()
        _homeDataFlow.value = result
    }
}