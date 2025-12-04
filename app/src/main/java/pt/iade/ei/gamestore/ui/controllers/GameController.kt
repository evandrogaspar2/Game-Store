package pt.iade.ei.gamestore.ui.controllers

import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.ui.modal.GameData

val games = listOf(
    GameData(
        id = 1,
        name = "Red Dead Redemption",
        description = "John Marston enfrenta o passado no Velho Oeste.",
        image = R.drawable.red_dead_redemption
    ),
    GameData(
        id = 2,
        name = "The Last of Us",
        description = "Joel e Ellie atravessam uma América pós-apocalíptica.",
        image = R.drawable.the_last_of_us
    ),
    GameData(
        id = 3,
        name = "Black Ops Cold War",
        description = "Conflito global durante a Guerra Fria com modo Zombies.",
        image = R.drawable.call_of_duty
    )
)

fun getGames(callback: (List<GameData>) -> Unit) {
    callback(games)
}