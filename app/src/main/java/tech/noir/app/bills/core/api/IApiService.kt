package tech.noir.app.bills.core.api

import tech.noir.app.bills.user.domain.model.User

interface IApiService {
    suspend fun getUserData(): User
}