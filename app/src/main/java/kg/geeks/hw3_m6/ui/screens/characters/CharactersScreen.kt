package kg.geeks.hw3_m6.ui.screens.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CharactersScreen(navController: NavController) {
    val characters = listOf(
        Character(1, "Рик Санчез", "Жив", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        Character(2, "Морти Смит", "Жив", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
        Character(3, "Саммер Смит", "Жив", "https://rickandmortyapi.com/api/character/avatar/3.jpeg")
    )

    LazyColumn {
        items(characters) { character ->
            CharacterItem(character) {
                navController.navigate("character_detail/${character.id}")
            }
        }
    }
}