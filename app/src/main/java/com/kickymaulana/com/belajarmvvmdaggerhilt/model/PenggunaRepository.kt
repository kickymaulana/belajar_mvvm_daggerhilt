package com.kickymaulana.com.belajarmvvmdaggerhilt.model

import kotlinx.coroutines.delay
import javax.inject.Inject

class PenggunaRepository @Inject constructor(
    private val penggunaService: PenggunaService
) {
    suspend fun getPengguna(): Pengguna{
        delay(2000)
        return Pengguna("Kicky Maulana", 36)
    }

    suspend fun getPenggunaFromNetwork(id: Int): RemotePengguna{
        return penggunaService.getDetailPengguna(id)
    }

}