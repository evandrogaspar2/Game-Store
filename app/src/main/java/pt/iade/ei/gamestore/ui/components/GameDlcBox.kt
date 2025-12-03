package pt.iade.ei.gamestore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.ui.classes.DlcData

@Composable
fun GameDlcBox(
    dlc: DlcData,
    onClick: () -> Unit
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{ onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip( RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            )
            {
                Image(
                    painter = painterResource(id = dlc.image),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                Text(
                    text = dlc.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = dlc.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    lineHeight = 20.sp,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$${dlc.price}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                    textAlign = TextAlign.End,
                    )
            }
        }
    }



@Preview
@Composable
fun GameDlcBoxPreview() {
    //GameDlcBox()
}