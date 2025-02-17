package kg.geeks.hw3_m6.ui.screens.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kg.geeks.hw3_m6.data.models.Character
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreen(navController: NavController, viewModel: CharactersViewModel = koinViewModel()) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn {
        items(characters) { character ->
            CharacterItem(character) {
                navController.navigate("character_detail/${character.id}")
            }
        }
    }
}