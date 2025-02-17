package kg.geeks.hw3_m6.data.api

import kg.geeks.hw3_m6.data.dto.ResponseCharacters
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {
    @GET("api/character")
    suspend fun fetchAllCharacters():Response<ResponseCharacters?>
}