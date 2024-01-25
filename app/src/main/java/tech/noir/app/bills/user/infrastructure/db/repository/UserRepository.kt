package tech.noir.app.bills.user.infrastructure.db.repository

import tech.noir.app.bills.user.domain.repository.IUserRepository
import tech.noir.app.bills.user.infrastructure.api.IUserApi
import tech.noir.app.bills.user.domain.model.User
import tech.noir.app.bills.security.application.response.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: IUserApi
) : IUserRepository {
    override suspend fun getUserByUuid(uuid: String): Response<User> {
        return try {
            val userResponse = api.getUserData(uuid)
            Response.Success(userResponse.userData)
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }
}