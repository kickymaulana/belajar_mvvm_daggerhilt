package com.kickymaulana.com.belajarmvvmdaggerhilt.model

import kotlinx.coroutines.delay

class PenggunaRepository {
    suspend fun getPengguna(): Pengguna{
        delay(2000)
        return Pengguna("Kicky Maulana", 36)
    }
}