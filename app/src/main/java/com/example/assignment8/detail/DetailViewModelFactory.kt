package com.example.assignment8.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment8.network.CharactersDetail

class DetailViewModelFactory(
    private val character: CharactersDetail
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) : T   {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java))    {
            return DetailViewModel(character) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}