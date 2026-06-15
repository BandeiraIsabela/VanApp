package com.example.vanapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.vanapp.model.Van
import com.example.vanapp.repository.VanRepository
import kotlinx.coroutines.launch

class VanViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = VanRepository(application)

    private val _vans = MutableLiveData<List<Van>>()
    val vans: LiveData<List<Van>> = _vans

    fun carregarVans() {
        viewModelScope.launch {
            val result = repository.getVans()
            _vans.postValue(result)
        }
    }
}