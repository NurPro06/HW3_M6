package kg.geeks.hw3_m6.data.api

import retrofit2.Response
import retrofit2.http.GET

interface LocationApiService {
    @GET("api/location")
    suspend fun fetchAllLocations(): Response<ResponseLocations?>
}