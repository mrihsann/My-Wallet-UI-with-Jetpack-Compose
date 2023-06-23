package com.ihsanarslan.mywallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ihsanarslan.mywallet.ui.theme.MyWalletTheme
import com.ihsanarslan.mywallet.view.History
import com.ihsanarslan.mywallet.view.Home

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF9052C8)) {
                    Home()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWalletTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF9052C8)) {
            Home()
        }
    }
}