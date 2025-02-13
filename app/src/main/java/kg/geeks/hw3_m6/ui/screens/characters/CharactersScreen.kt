package kg.geeks.hw3_m6.ui.screens.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kg.geeks.hw3_m6.data.models.Character

@Composable
fun CharactersScreen(navController: NavController) {
    val characters = listOf(
        kg.geeks.hw3_m6.data.models.Character(
            1,
            "Рик Санчез",
            "Жив",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "Человек",
            "Мужской",
            "Земля (C-137)"
        ),
        kg.geeks.hw3_m6.data.models.Character(
            2,
            "Морти Смит",
            "Жив",
            "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            "Человек",
            "Мужской",
            "Земля (C-137)"
        ),
        Character(3, "Саммер Смит", "Жив", "https://rickandmortyapi.com/api/character/avatar/3.jpeg", "Человек", "Женский", "Земля (C-137)")
    )

    LazyColumn {
        items(characters) { character ->
            CharacterItem(character) {
                navController.navigate("character_detail/${character.id}")
            }
        }
    }
}
