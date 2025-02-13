package kg.geeks.hw3_m6.ui.screens.characters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kg.geeks.hw3_m6.data.models.Character

@Composable
fun CharacterDetailScreen(navController: NavController, characterId: String) {
    val character = Character(
        id = characterId.toInt(),
        name = "Рик Санчез",
        status = "Жив",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        species = "Человек",
        gender = "Мужской",
        location = "Земля (C-137)"
    )
    val character2 = Character(
        id = characterId.toInt(),
        name = "Морти Смит",
        status = "Жив",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        species = "Человек",
        gender = "Мужской",
        location = "Земля (C-137)"
    )
    val character3 = Character(
        id = characterId.toInt(),
        name = "Саммер Смит",
        status = "Жив",
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        species = "Человек",
        gender = "Женский",
        location = "Земля (C-137)"

    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = character.imageUrl,
            contentDescription = character.name,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = character.name, style = MaterialTheme.typography.headlineLarge)
        Text(text = "Статус: ${character.status}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Вид: ${character.species}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Пол: ${character.gender}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Местоположение: ${character.location}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Назад")
        }
    }
}
