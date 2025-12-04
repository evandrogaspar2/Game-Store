package pt.iade.ei.gamestore.ui.modal

import java.io.Serializable


data class DlcData (
    val id: Int,
    val gameId: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: Int
) : Serializable