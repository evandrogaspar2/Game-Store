package pt.iade.ei.gamestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.ui.classes.DlcData
import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.components.GameDlcBox
import pt.iade.ei.gamestore.ui.components.GameInfoBox
import pt.iade.ei.gamestore.ui.controllers.dlcGames
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme


class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val game = intent.getSerializableExtra("game") as GameData
        val dlcs = dlcGames.filter { it.gameId == game.id }

        setContent {
            GameStoreTheme {
                GameDetailScreen(
                    game = game,
                    dlcs = dlcs,
                    onBack = { finish() }
                )
            }
        }
    }
}

@Composable
fun GameDetailScreen(
    game: GameData,
    dlcs: List<DlcData>,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            Box(
                Modifier
                    .background(Color(0xFFF7F2FA))
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }

                    Text(game.name, modifier = Modifier.weight(1f))

                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.FavoriteBorder, null)
                    }
                }
            }
        }
    ) { padding ->

        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F2FA))
                .padding(padding)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item { GameInfoBox(game) }

            items(dlcs) { dlc ->
                GameDlcBox(dlc)
            }
        }
    }
}