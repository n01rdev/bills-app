package tech.noir.app.bills.user.infrastructure.api

import retrofit2.http.GET
import retrofit2.http.Path
import tech.noir.app.bills.user.application.response.UserResponse

fun interface IUserApi {
    @GET("user/{uuid}")
    suspend fun getUserData(@Path("uuid") uuid: String): UserResponse
}