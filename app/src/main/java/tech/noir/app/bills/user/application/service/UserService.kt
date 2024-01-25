package tech.noir.app.bills.user.application.service

import tech.noir.app.bills.user.infrastructure.db.repository.UserRepository
import javax.inject.Inject

class UserService @Inject constructor(
    private val repository: UserRepository
) {
    suspend fun getUserData(uuid: String) = repository.getUserByUuid(uuid)
}