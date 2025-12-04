package pt.iade.ei.gamestore.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore.ui.theme.NavBarBackgroundColor
import pt.iade.ei.gamestore.ui.theme.NavBarSelectedColor


@Composable
fun NavBar() {

    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = NavBarBackgroundColor
    ) {
        NavigationBarItem(
            selected =  selectedItem == 0,
            onClick = { selectedItem = 0},
            icon = {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = "Featured"
                )
            },
            label = {
                Text("Featured")
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if (selectedItem == 0)
                    NavBarSelectedColor
                else
                    Color.Transparent,
            )
        )
        NavigationBarItem(
            selected = selectedItem == 1,
            onClick = { selectedItem = 1},
            icon = {
                Icon(
                    Icons.Outlined.ExitToApp,
                    contentDescription = "History"
                )
            },
            label = {
                Text("History")
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if (selectedItem == 1)
                    NavBarSelectedColor
                else
                    Color.Transparent,
            )

            )
        NavigationBarItem(
            selected = selectedItem == 2,
            onClick = {selectedItem = 2},
            icon = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if (selectedItem == 2)
                    NavBarSelectedColor
                else
                    Color.Transparent,
            )
        )
    }
}


@Preview
@Composable
fun NavigationBarPreview() {
    NavBar()
}
