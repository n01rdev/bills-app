package tech.noir.app.bills.user.infrastructure.db.repository

import tech.noir.app.bills.security.application.response.Response
import tech.noir.app.bills.security.infrastructure.network.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun loadHomeData(): Response<UserData> {
        // Aquí haces la llamada a la API utilizando Retrofit
        // y devuelves el resultado
    }
}