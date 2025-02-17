package kg.geeks.hw3_m6.ui.screens.locations

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.hw3_m6.data.repository.LocationsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(private val repository: LocationsRepository) : ViewModel() {
    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations: StateFlow<List<Location>> = _locations

    init {
        viewModelScope.launch {
            _locations.value = repository.fetchAllLocations()
        }
    }
}