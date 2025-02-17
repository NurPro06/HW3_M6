package kg.geeks.hw3_m6.ui.screens.locations

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LocationsScreen(navController: NavController, viewModel: LocationsViewModel = koinViewModel()) {
    val locations by viewModel.locations.collectAsState()

    LazyColumn {
        items(locations) { location ->
            Text(location.name)
        }
    }
}