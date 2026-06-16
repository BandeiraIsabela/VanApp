package com.example.vanapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.vanapp.database.AppDatabase
import com.example.vanapp.model.Van
import com.example.vanapp.repository.VanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VanViewModel(application: Application) : AndroidViewModel(application) {

    // Inicialização tardia do repositório para não travar a UI Thread no construtor
    private val repository: VanRepository by lazy {
        VanRepository(AppDatabase.getDatabase(application).vanDao())
    }

    private val _vans = MutableLiveData<List<Van>>()
    val vans: LiveData<List<Van>> = _vans

    fun carregarVans() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getVans()
                _vans.postValue(result)
            } catch (e: Exception) {
                _vans.postValue(emptyList())
            }
        }
    }

    // Apenas para testes
    private var testRepository: VanRepository? = null
    fun setRepository(repo: VanRepository) {
        this.testRepository = repo
    }
}