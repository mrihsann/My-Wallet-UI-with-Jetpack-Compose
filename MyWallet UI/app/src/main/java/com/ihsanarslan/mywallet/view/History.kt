package com.ihsanarslan.mywallet.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun History(){
    Column() {
        Spacer(modifier = Modifier.height(30.dp))
        Top(title="History")
        Spacer(modifier = Modifier.height(50.dp))
        BackgroundHistory()
    }
}


@Composable
fun BackgroundHistory(){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color(0xFFFBFBFB))
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Items()
    }
}