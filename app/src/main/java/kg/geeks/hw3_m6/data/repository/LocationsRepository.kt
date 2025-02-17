package kg.geeks.hw3_m6.data.repository

import android.health.connect.datatypes.ExerciseRoute
import kg.geeks.hw3_m6.data.api.LocationApiService

class LocationsRepository(private val locationApiService: LocationApiService) {
    suspend fun fetchAllLocations(): List<ExerciseRoute.Location> {
        val response = locationApiService.fetchAllLocations()
        return if (response.isSuccessful) {
            response.body()?.results?.map { it.toLocation() } ?: emptyList()
        } else {
            emptyList()
        }
    }
}
