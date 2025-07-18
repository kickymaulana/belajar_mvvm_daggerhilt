package com.kickymaulana.com.belajarmvvmdaggerhilt.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class RemotePengguna(
    @SerializedName("name")
    var nama: String,

    @SerializedName("email")
    var email: String,
)