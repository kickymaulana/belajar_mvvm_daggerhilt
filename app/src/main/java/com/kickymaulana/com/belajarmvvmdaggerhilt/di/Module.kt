package com.kickymaulana.com.belajarmvvmdaggerhilt.di

import androidx.core.content.pm.PermissionInfoCompat
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.PenggunaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun providePenggunaRepository(): PenggunaRepository{
        return PenggunaRepository()
    }
}