package pt.iade.ei.gamestore.ui.classes

import java.io.Serializable

data class GameData(
    val id: Int,
    val name: String,
    val description: String,
    val image: Int

) : Serializable