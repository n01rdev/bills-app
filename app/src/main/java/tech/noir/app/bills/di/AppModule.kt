package tech.noir.app.bills.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.noir.app.bills.security.domain.repository.IAuthRepository
import tech.noir.app.bills.security.infrastructure.db.repository.AuthRepository
import tech.noir.app.bills.user.domain.repository.IUserRepository
import tech.noir.app.bills.user.infrastructure.api.IUserApi
import tech.noir.app.bills.user.infrastructure.db.repository.UserRepository

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepository): IAuthRepository = impl

    @Provides
    fun provideUserRepository(impl: UserRepository): IUserRepository = impl

    @Provides
    //TODO: Modularize this and move it to a separate module to improve scalability
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://your-api-url.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideUserApi(retrofit: Retrofit): IUserApi {
        return retrofit.create(IUserApi::class.java)
    }
}