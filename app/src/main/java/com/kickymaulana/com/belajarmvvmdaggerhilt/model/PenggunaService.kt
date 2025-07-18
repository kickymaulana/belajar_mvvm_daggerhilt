package com.kickymaulana.com.belajarmvvmdaggerhilt.model

import retrofit2.http.GET
import retrofit2.http.Path

interface PenggunaService {

    @GET("users/{id}")
    suspend fun getDetailPengguna(@Path("id") id: Int): RemotePengguna
}