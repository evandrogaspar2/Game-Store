package pt.iade.ei.gamestore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.ui.classes.DlcData
import pt.iade.ei.gamestore.ui.theme.AppBackground
import pt.iade.ei.gamestore.ui.theme.Purple40


@Composable
fun DlcBottomSheet(
    dlc: DlcData,
    onBuyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Text(
            text = dlc.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = dlc.image),
                contentDescription = dlc.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = dlc.description,
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 18.sp,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$${dlc.price}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = onBuyClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Buy with 1-click",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}