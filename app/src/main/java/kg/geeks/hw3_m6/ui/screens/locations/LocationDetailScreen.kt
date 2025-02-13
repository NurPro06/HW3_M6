package kg.geeks.hw3_m6.ui.screens.locations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LocationDetailScreen(navController: NavController, locationId: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Детали локации",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Локация ID: $locationId",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Назад")
        }
    }
}