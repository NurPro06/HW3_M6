package kg.geeks.hw3_m6.data.repository

import kg.geeks.hw3_m6.data.api.EpisodeApiService

class EpisodesRepository(private val episodeApiService: EpisodeApiService) {
    suspend fun fetchAllEpisodes(): List<Episode> {
        val response = episodeApiService.fetchAllEpisodes()
        return if (response.isSuccessful) {
            response.body()?.results?.map { it.toEpisode() } ?: emptyList()
        } else {
            emptyList()
        }
    }
}