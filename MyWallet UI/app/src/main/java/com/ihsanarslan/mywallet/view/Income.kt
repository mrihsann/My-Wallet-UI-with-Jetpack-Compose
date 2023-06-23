package com.ihsanarslan.mywallet.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihsanarslan.mywallet.R
import com.ihsanarslan.mywallet.ui.theme.MyWalletTheme

@Composable
fun Income(){
    Column() {
        Spacer(modifier = Modifier.height(30.dp))
        Top(title="Income Money")
        Spacer(modifier = Modifier.height(50.dp))
        Background()
    }
}

@Composable
fun Top(title:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            //buraya logo gelecek
            painter = painterResource(R.drawable.back),
            contentDescription = "image",
            modifier = Modifier
                .size(35.dp)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = 35.dp), // Metnin genişliği tüm boşluğu kaplamasını sağlar
            contentAlignment = Alignment.Center // Metni ortalamak için hizalama
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                color = Color.White
            )
        }

    }
}

@Composable
fun Background(){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color(0xFFFBFBFB))
    ) {

        Spacer(modifier = Modifier.height(50.dp))
        TitleCard()
        Spacer(modifier = Modifier.height(50.dp))
        CounterMoney()
        Spacer(modifier = Modifier.height(50.dp))
        Grid()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleCard() {
    var head = remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .height(70.dp)
            .padding(horizontal = 35.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(20.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .aspectRatio(1f)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                val iconText = head.value.take(1).uppercase()
                Text(
                    text = iconText,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(0XFF9052C8),
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            TextField(
                value = head.value,
                onValueChange = { newText -> head.value = newText },
                label = { Text("Enter text") }
            )
        }
    }
}






@Composable
fun Grid(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            MyButton(text = "1")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "2")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "3")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            MyButton(text = "4")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "5")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "6")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            MyButton(text = "7")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "8")
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "9")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            MyButtonImage(painterResource(R.drawable.del),Color(0XFFBABABA))
            Spacer(modifier = Modifier.width(16.dp))
            MyButton(text = "0")
            Spacer(modifier = Modifier.width(16.dp))
            MyButtonImage(painterResource(R.drawable.arrow_right),Color(0XFF9052C8))
        }
    }
}

@Composable
fun CounterMoney(){
    Text(modifier = Modifier.fillMaxWidth(), text = "$1500", color = Color.Black, fontSize = 50.sp, fontWeight = FontWeight.SemiBold,textAlign = TextAlign.Center)
}



@Composable
fun MyButton(text:String) {
    Button(
        onClick = { /* Buton tıklama işlemi */ },
        shape = CircleShape,
        modifier = Modifier.size(70.dp),
        colors = ButtonDefaults.buttonColors(Color.White),

    ) {
        // Buton içeriği
        Text(
            text = (text),
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0XFF42353B),
            fontSize = 30.sp
        )
    }
}

@Composable
fun MyButtonImage(image:Painter,color: Color) {
    Button(
        onClick = { /* Buton tıklama işlemi */ },
        shape = CircleShape,
        modifier = Modifier.size(70.dp),
        colors = ButtonDefaults.buttonColors(color),

        ) {
        // Buton içeriği
        Image(painter = image , contentDescription ="image",Modifier.size(30.dp) )
    }
}
