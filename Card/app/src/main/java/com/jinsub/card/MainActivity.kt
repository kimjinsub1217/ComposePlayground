package com.jinsub.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinsub.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCard()
        }
    }
}


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.Cyan),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Text(
            text = "신나는 카드 놀이",
            modifier = Modifier.padding(16.dp)
        )
    }
}
