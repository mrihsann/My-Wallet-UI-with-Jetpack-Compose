package com.ihsanarslan.mywallet.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Expense(){
    Column() {
        Spacer(modifier = Modifier.height(30.dp))
        Top(title = "Expense Money")
        Spacer(modifier = Modifier.height(50.dp))
        Background()
    }
}