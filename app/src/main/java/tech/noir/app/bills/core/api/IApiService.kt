package tech.noir.app.bills.core.api

fun interface IApiService<T, R> {
    suspend fun request(data: T): R
}