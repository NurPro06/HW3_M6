package kg.geeks.hw3_m6.ui.screens.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.hw3_m6.data.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
) : ViewModel() {
    init {
        fetchAllCharacters()
    }

    fun fetchAllCharacters() {
        viewModelScope.launch {
            val data = charactersRepository.fetchAllCharacters()
            Log.e("ololo", "fetchAllCharacters: $data")
        }
    }

}