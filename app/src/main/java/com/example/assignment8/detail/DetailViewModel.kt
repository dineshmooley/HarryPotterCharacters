package com.example.assignment8.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment8.network.CharactersDetail

class DetailViewModel(val character : CharactersDetail) : ViewModel() {

    private val _navigateToJson = MutableLiveData<Boolean>()
    val navigateToJson : LiveData<Boolean>
        get() = _navigateToJson

    fun startNavigating()   {
        _navigateToJson.value = true
    }

    fun doneNavigating()    {
        _navigateToJson.value = false
    }
}