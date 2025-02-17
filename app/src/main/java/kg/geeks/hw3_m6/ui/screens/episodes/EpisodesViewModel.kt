package kg.geeks.hw3_m6.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.hw3_m6.data.repository.EpisodesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(private val repository: EpisodesRepository) : ViewModel() {
    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    init {
        viewModelScope.launch {
            _episodes.value = repository.fetchAllEpisodes()
        }
    }
}