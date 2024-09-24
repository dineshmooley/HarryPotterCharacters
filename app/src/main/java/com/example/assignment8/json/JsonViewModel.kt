package com.example.assignment8.json

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment8.network.CharacterApi
import com.example.assignment8.network.CharactersDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class JsonViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<CharactersDetail>>()
    val properties : LiveData<List<CharactersDetail>>
        get() = _properties

    private val _navigateToImage = MutableLiveData<Boolean>()
     val navigateToImage : LiveData<Boolean>
         get() = _navigateToImage

    lateinit var character : List<CharactersDetail>

    fun startNavigating()   {
        _navigateToImage.value = true
    }

    fun doneNavigating()    {
        _navigateToImage.value = false
    }

    fun generate()  {
        getCharacters()
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private fun getCharacters() {

        coroutineScope.launch {
            val listResult = CharacterApi.retrofitService.getCharacter()
            _properties.value = listResult
        }
    }

    fun setCharacter()    {
        character = properties.value!!
    }
}