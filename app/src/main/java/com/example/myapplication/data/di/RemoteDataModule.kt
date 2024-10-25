package com.example.myapplication.data.di

import com.example.myapplication.data.FirebaseConnectorImpl
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideFirebaseConnector() = FirebaseConnectorImpl(Firebase.firestore)
}
