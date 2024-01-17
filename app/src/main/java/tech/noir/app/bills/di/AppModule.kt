package tech.noir.app.bills.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.noir.app.bills.security.domain.repository.IAuthRepository
import tech.noir.app.bills.security.infrastructure.db.repository.AuthRepository

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepository): IAuthRepository = impl
}