package com.ihsanarslan.mywallet.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihsanarslan.mywallet.ProcessMoney
import com.ihsanarslan.mywallet.R

@Composable
fun Home(){
    Column {
        Spacer(modifier = Modifier.height(30.dp))
        TopUp("Ihsan")
        Spacer(modifier = Modifier.height(30.dp))
        Balance(654561)
        Spacer(modifier = Modifier.height(100.dp))
        Content()
    }
}

@Composable
fun TopUp(name:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            //buraya logo gelecek
            painter = painterResource(R.drawable.baseline_person_24),
            contentDescription = "image",
            modifier = Modifier.size(35.dp))
        Text(
            text = "Hello, $name",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            color = Color.White)
        Image(
            painter = painterResource(R.drawable.notification),
            contentDescription = "image",
            modifier = Modifier.size(35.dp))
    }
}

@Composable
fun Balance(balance: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Available Balance",
            color = Color(0xFFAD9CDB),
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "$987,254.52",
            color = Color.White,
            fontSize = 40.sp,
        )
    }
}

@Composable
fun Menu() {
    Row(Modifier.fillMaxSize(1f),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(
            Modifier
                .fillMaxHeight(1f)
            ,horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(R.drawable.cash_in),
                contentDescription = "image",
                modifier = Modifier.size(35.dp))
            Text(
                text = "Income",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                color = Color.Black)

        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp)
                .padding(top = 10.dp, bottom = 10.dp)
                .background(Color.Gray)
        ){}
        Column(
            Modifier
                .fillMaxHeight(1f)
            ,horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(R.drawable.cash_out),
                contentDescription = "image",
                modifier = Modifier.size(35.dp))
            Text(
                text = "Expense",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp),
                color = Color.Black)
        }
    }
}


@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            HistoryHome()
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .height(96.dp)
                .offset(y = (-24).dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Menu()
        }
    }
}

@Composable
fun HistoryHome(){
    Column() {
        Row(modifier = Modifier.padding(top = 60.dp, bottom = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(modifier = Modifier.padding(start = 20.dp),text = "History",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                color = Color.DarkGray)
            Spacer(modifier = Modifier.weight(1f))
            Text(modifier = Modifier
                .padding(end = 20.dp)
                ,text = "See all..",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp),
                color = Color.DarkGray)
        }
        Items()
    }

}


@Composable
fun Items(){
    val itemList = remember { mutableStateListOf<ProcessMoney>() }
    itemList.add(ProcessMoney("Kuryeye Ödeme",245.23,false))
    itemList.add(ProcessMoney("Takı Satışı",178.54,true))
    itemList.add(ProcessMoney("Kredi Borcu",3654.74,false))
    itemList.add(ProcessMoney("Market Alışverişi",2654.47,false))
    itemList.add(ProcessMoney("Maaş",34850.65,true))

    LazyColumn {
        items(itemList) { item ->
            PriceCard(head = item.head, price = item.price.toString(),item.type)
        }
    }
}
