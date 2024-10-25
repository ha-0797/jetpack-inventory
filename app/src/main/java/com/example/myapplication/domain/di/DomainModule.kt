package com.example.myapplication.domain.di

import com.example.myapplication.data.di.RemoteDataModule
import com.example.myapplication.domain.InventoryItemRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DomainModule {

    @Provides
    fun provideInventoryItemRepository() = InventoryItemRepositoryImpl(
        RemoteDataModule.provideFirebaseConnector()
    )
}