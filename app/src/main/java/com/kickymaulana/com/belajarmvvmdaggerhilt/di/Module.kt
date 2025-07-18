package com.kickymaulana.com.belajarmvvmdaggerhilt.di

import androidx.core.content.pm.PermissionInfoCompat
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.PenggunaRepository
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.PenggunaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun providePenggunaRepository(penggunaService: PenggunaService): PenggunaRepository{
        return PenggunaRepository(penggunaService)
    }

    @Singleton
    @Provides
    fun providePenggunaService(): PenggunaService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PenggunaService::class.java)
    }
}