package pt.iade.ei.gamestore

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.ui.classes.DlcData
import pt.iade.ei.gamestore.ui.classes.GameData
import pt.iade.ei.gamestore.ui.components.DlcBottomSheet
import pt.iade.ei.gamestore.ui.components.GameDlcBox
import pt.iade.ei.gamestore.ui.components.GameInfoBox
import pt.iade.ei.gamestore.ui.controllers.getDlcGames
import pt.iade.ei.gamestore.ui.theme.AppBackgroundColor
import pt.iade.ei.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = intent.getSerializableExtra("game") as? GameData

        if (game == null) {
            finish()
            return
        }

        var dlcs: List<DlcData> = emptyList()

        getDlcGames { list ->
            dlcs = list.filter { it.gameId == game.id }
        }

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

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    game: GameData,
    dlcs: List<DlcData>,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    var selectedDlc by remember { mutableStateOf<DlcData?>(null) }
    var showSheet by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    // Mostra o ModalBottomSheet quando showSheet = true
    if (showSheet) {
        selectedDlc?.let { dlc ->
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = AppBackgroundColor
            ) {
                DlcBottomSheet(
                    dlc = dlc,
                    onBuyClick = {
                        showSheet = false
                        Toast.makeText(
                            context,
                            "Acabou de comprar o item ${dlc.name} por $${dlc.price}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            }
        }
    }

    Scaffold(
        topBar = {
            Box(
                Modifier
                    .background(AppBackgroundColor)
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }

                    Text(
                        text = game.name,
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorite")
                    }
                }
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(AppBackgroundColor)
                .padding(padding)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                GameInfoBox(game)
            }

            item {
                Row(
                    modifier = Modifier
                        .padding(start = 2.dp )
                ){
                    Text(
                        text = "Purchasable items",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                }
            }

            items(dlcs) { dlc ->
                GameDlcBox(
                    dlc = dlc,
                    onClick = {
                        selectedDlc = dlc
                        showSheet = true
                    }
                )
            }
        }
    }
}