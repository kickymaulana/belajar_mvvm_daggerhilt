package com.kickymaulana.com.belajarmvvmdaggerhilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.Pengguna
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.PenggunaRepository
import com.kickymaulana.com.belajarmvvmdaggerhilt.model.RemotePengguna
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PenggunaViewModel @Inject constructor(
    private val penggunaRepository: PenggunaRepository
): ViewModel() {

    private val _pengguna: MutableStateFlow<Pengguna> = MutableStateFlow(Pengguna("", 0))
    val pengguna: StateFlow<Pengguna> = _pengguna

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _remotePengguna: MutableStateFlow<RemotePengguna> = MutableStateFlow(RemotePengguna(nama = "", ""))
    val remotePengguna: StateFlow<RemotePengguna> = _remotePengguna

    fun getPengguna(){
        viewModelScope.launch {
            _isLoading.update { true }
            _pengguna.update {
                penggunaRepository.getPengguna()
            }
            _isLoading.update { false }
        }
    }

    fun getPenggunaFromNetwork(id: Int){
        viewModelScope.launch {
            _isLoading.update { true }
            _remotePengguna.update {
                penggunaRepository.getPenggunaFromNetwork(id)
            }
            _isLoading.update { false }
        }

    }
}