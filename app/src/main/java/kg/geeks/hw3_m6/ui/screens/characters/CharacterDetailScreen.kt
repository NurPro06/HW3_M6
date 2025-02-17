package kg.geeks.hw3_m6.ui.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharacterDetailScreen(navController: NavController, characterId: String, viewModel: CharactersViewModel = koinViewModel()) {
    val character by viewModel.getCharacter(characterId.toInt()).collectAsState()

    character?.let {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(16.dp)) {
            AsyncImage(model = it.imageUrl, contentDescription = it.name, modifier = Modifier.size(180.dp).clip(CircleShape), contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = it.name, style = MaterialTheme.typography.headlineLarge)
            Text(text = "Статус: ${it.status}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Вид: ${it.species}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Пол: ${it.gender}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Местоположение: ${it.location}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) { Text("Назад") }
        }
    }
}