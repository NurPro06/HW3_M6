package kg.geeks.hw3_m6.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute !in listOf("character_detail", "location_detail", "episode_detail")) {
                TopAppBar(title = { Text(currentRoute ?: "Приложение") })
            }
        },
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute !in listOf("character_detail", "location_detail", "episode_detail")) {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "characters",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("characters") { CharactersScreen(navController) }
            composable("locations") { LocationsScreen(navController) }
            composable("episodes") { EpisodesScreen(navController) }

            composable("character_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id") ?: "Unknown"
                CharacterDetailScreen(navController, id)
            }
            composable("location_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id") ?: "Unknown"
                LocationDetailScreen(navController, id)
            }
            composable("episode_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id") ?: "Unknown"
                EpisodeDetailScreen(navController, id)
            }
        }
    }
}