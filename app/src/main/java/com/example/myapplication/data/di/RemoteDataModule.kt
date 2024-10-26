package com.example.myapplication.data.di

import com.example.myapplication.data.FirebaseConnector
import com.example.myapplication.data.FirebaseConnectorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseConnector(
        firebaseConnectorImpl: FirebaseConnectorImpl
    ): FirebaseConnector
}
