package tech.noir.app.bills.user.domain.repository

import tech.noir.app.bills.user.domain.model.User
import tech.noir.app.bills.security.application.response.Response

fun interface IUserRepository {
    suspend fun getUserByUuid(uuid: String): Response<User>
}