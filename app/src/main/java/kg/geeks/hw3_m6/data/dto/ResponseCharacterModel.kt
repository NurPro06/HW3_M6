package kg.geeks.hw3_m6.data.dto

data class ResponseCharacterModel(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val type: String? = null,
    val species: String? = null,
    val gender: String? = null,
    val origin: OriginModel? = null,
    val image: String? = null
)
data class OriginModel(
    val name: String? = null,
    val url: String? = null

)
data class ResponseCharacters(
    val results: List<ResponseCharacterModel>? = null
)
