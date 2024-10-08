package com.example.cube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cube.ui.theme.CubeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CubeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CubeImageScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CubeImageScreen(modifier: Modifier = Modifier) {
    var randomCubeId by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cube de Jeux",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        // Afficher l'image du cube aléatoire
        if (randomCubeId != 0) {
            Image(
                painter = painterResource(id = randomCubeId),
                contentDescription = "Cube Image",
                modifier = Modifier.size(100.dp) // Ajustez la taille selon vos besoins
            )
        } else {
            Text(
                text = "Cliquez sur le bouton!",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Bouton pour générer une image de cube aléatoire
        Button(onClick = {
            // Générer un ID de ressource d'image aléatoire entre cube_1 à cube_9
            randomCubeId = when (Random.nextInt(1, 10)) {
                1 -> R.drawable.cube_1
                2 -> R.drawable.cube_2
                3 -> R.drawable.cube_3
                4 -> R.drawable.cube_4
                5 -> R.drawable.cube_5
                6 -> R.drawable.cube_6
                else -> 0 // Par défaut
            }
        }) {
            Text(text = "Générer un cube")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CubeImageScreenPreview() {
    CubeTheme {
        CubeImageScreen()
    }
}
