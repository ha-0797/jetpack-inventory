package com.example.myapplication.domain.di

import com.example.myapplication.domain.InventoryItemRepository
import com.example.myapplication.domain.InventoryItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Singleton
    @Binds
    abstract fun bindsInventoryItemRepository(
        inventoryItemRepositoryImpl: InventoryItemRepositoryImpl
    ): InventoryItemRepository
}
