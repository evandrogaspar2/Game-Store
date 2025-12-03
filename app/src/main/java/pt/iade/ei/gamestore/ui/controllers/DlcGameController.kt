package pt.iade.ei.gamestore.ui.controllers

import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.classes.DlcData

val dlcGames = listOf(

    // Red Dead Redemption
    DlcData(
        id = 1,
        gameId = 1,
        name = "Undead Nightmare",
        description = "Grande expansão zombie no Velho Oeste enquanto John procura uma cura.",
        price = 9.99,
        image = R.drawable.rdr_undead_nightmare
    ),
    DlcData(
        id = 2,
        gameId = 1,
        name = "Legends and Killers Pack",
        description = "Novos personagens clássicos, armas e mapas multijogador.",
        price = 6.99,
        image = R.drawable.rdr_legend_killers
    ),
    DlcData(
        id = 3,
        gameId = 1,
        name = "Liars and Cheats Pack",
        description = "Jogos de salão, corridas de cavalos competitivas, PvP e novas armas.",
        price = 7.99,
        image = R.drawable.rdr_liars_cheats
    ),

    // The Last of Us
    DlcData(
        id = 4,
        gameId = 2,
        name = "Left Behind",
        description = "Expansão narrativa que mostra o passado de Ellie e a relação com Riley.",
        price = 9.99,
        image = R.drawable.tu_left_behind
    ),
    DlcData(
        id = 5,
        gameId = 2,
        name = "Abandoned Territories",
        description = "Pacote multiplayer com quatro novos mapas intensos.",
        price = 5.99,
        image = R.drawable.tu_abandoned_pack
    ),
    DlcData(
        id = 6,
        gameId = 2,
        name = "Reclaimed Territories",
        description = "Mais quatro mapas, novas armas e execuções no multiplayer.",
        price = 7.99,
        image = R.drawable.tu_reclaimed_pack
    ),

    // Black Ops Cold War
    DlcData(
        id = 7,
        gameId = 3,
        name = "Zombies – Firebase Z",
        description = "Mapa Zombies numa base secreta no Vietname com novos inimigos.",
        price = 6.99,
        image = R.drawable.cd_zumbies_firebase
    ),
    DlcData(
        id = 8,
        gameId = 3,
        name = "Zombies – Mauer der Toten",
        description = "Zombies em Berlim destruída com novas armas e exploração urbana.",
        price = 6.99,
        image = R.drawable.cd_mauer_der_toten
    ),
    DlcData(
        id = 9,
        gameId = 3,
        name = "Zombies – Forsaken",
        description = "Capítulo final da Dark Aether numa cidade soviética experimental.",
        price = 6.99,
        image = R.drawable.cd_zombies_forsaken
    )
)

fun getDlcGames(callback: (List<DlcData>) -> Unit) {
    callback(dlcGames)
}