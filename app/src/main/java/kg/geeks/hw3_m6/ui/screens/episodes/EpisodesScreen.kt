package kg.geeks.hw3_m6.ui.screens.episodes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodesScreen(navController: NavController, viewModel: EpisodesViewModel = koinViewModel()) {
    val episodes by viewModel.episodes.collectAsState()

    LazyColumn {
        items(episodes) { episode ->
            Text(episode.name)
        }
    }
}