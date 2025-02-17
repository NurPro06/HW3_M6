package kg.geeks.hw3_m6.data.repository

import kg.geeks.hw3_m6.data.api.CharacterApiService
import kg.geeks.hw3_m6.data.dto.ResponseCharacterModel

class CharactersRepository(private val characterApiService: CharacterApiService) {
    suspend fun fetchAllCharacters(): List<Character> {
        val response = characterApiService.fetchAllCharacters()
        return if (response.isSuccessful) {
            response.body()?.results?.map { it.toCharacter() } ?: emptyList()
        } else {
            emptyList()
        }
    }
}

fun ResponseCharacterModel.toCharacter(): Character {
    return Character(
        id = id ?: 0,
        name = name.orEmpty(),
        status = status.orEmpty(),
        imageUrl = image.orEmpty(),
        species = species.orEmpty(),
        gender = gender.orEmpty(),
        location = origin?.name.orEmpty()
    )
}