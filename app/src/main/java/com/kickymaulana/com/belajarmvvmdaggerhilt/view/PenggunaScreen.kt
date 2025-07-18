package com.kickymaulana.com.belajarmvvmdaggerhilt.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kickymaulana.com.belajarmvvmdaggerhilt.viewmodel.PenggunaViewModel

@Composable
fun PenggunaScreen(modifier: Modifier, viewModel: PenggunaViewModel = viewModel()){

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val pengguna by viewModel.pengguna.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.getPengguna()
            }
        ) {
            Text(text = "Sapa Pengguna")
        }
        if (isLoading){
            CircularProgressIndicator()
        } else {
            Text(text = "Selamat Datang ${pengguna.nama}")
        }
    }

}
