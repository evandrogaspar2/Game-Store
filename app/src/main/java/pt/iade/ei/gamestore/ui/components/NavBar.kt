package pt.iade.ei.gamestore.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun NavBar() {
    NavigationBar() {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = "Featured"
                )
            },
            label = {
                Text("Featured")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Outlined.ExitToApp,
                    contentDescription = "History"
                )
            },
            label = {
                Text("History")
            },

            )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            }
        )
    }
}


@Preview
@Composable
fun NavigationBarPreview() {
    NavBar()
}
