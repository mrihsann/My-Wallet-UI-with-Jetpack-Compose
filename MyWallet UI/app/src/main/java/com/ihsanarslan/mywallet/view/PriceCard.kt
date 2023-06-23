package com.ihsanarslan.mywallet.view

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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceCard(head:String, price:String, type:Boolean){

    // Açılıp kapanabilirlik durumunu tutacak bir MutableState kullanıyoruz
    val isExpanded = remember { mutableStateOf(false) }

    Column(Modifier.padding(start = 15.dp, end = 15.dp, top = 2.dp, bottom = 2.dp)) {
        Card(
            modifier = Modifier
                .clickable { isExpanded.value = !isExpanded.value }
                .fillMaxWidth()
                .shadow(4.dp)
                .height(65.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    val iconText = head.take(1)
                    Text(
                        text = iconText,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = if (head.length > 15) "${head.take(15)}..." else head,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = if (price.length > 6) "${price.take(6)}..." else price,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold, fontSize = 18.sp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (type) Color(0xFF4CAF50) else Color.Red
                )
            }

        }
        // Alt kartın açılması durumunda gösterilmesi için bir if bloğu kullanıyoruz
        if (isExpanded.value) {
            Box(Modifier.padding(horizontal = 15.dp)) {
                Card(
                    modifier = Modifier
                        .height(30.dp)
                        .shadow(4.dp),
                    shape = RoundedCornerShape(0.dp,0.dp,10.dp,10.dp),
                ) {
                    Row(modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = head,
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal, fontSize = 10.sp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = price,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal, fontSize = 13.sp),
                            color = if (type) Color(0xFF4CAF50) else Color.Red
                        )

                    }
                }
            }

        }
    }
}