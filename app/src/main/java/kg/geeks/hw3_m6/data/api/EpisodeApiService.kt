package kg.geeks.hw3_m6.data.api

import retrofit2.Response
import retrofit2.http.GET

interface EpisodeApiService {
    @GET("api/episode")
    suspend fun fetchAllEpisodes(): Response<ResponseEpisodes?>
}