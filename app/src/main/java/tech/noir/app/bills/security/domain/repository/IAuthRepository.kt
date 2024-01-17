package tech.noir.app.bills.security.domain.repository

import com.google.firebase.auth.FirebaseUser
import tech.noir.app.bills.security.application.response.Response

interface IAuthRepository {
    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signup(name: String, email: String, password: String): Response<FirebaseUser>
    fun logout()
}