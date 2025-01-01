package com.jinsub.button

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                FilledButton({ Log.v("TAGV", "FilledButton 클릭") })
                FilledTonal({ Log.v("TAGV", "FilledTonal 클릭") })
                ElevatedButton({ Log.v("TAGV", "ElevatedButton 클릭") })
                OutLinedButton({ Log.v("TAGV", "OutLinedButton 클릭") })
                TextButton({ Log.v("TAGV", "TextButton 클릭") })
            }
        }
    }
}

// Button Composable
// 1- Filled Button 채워진 버튼
@Composable
fun FilledButton(onClock: () -> Unit) {
    Button(onClick = { onClock() }
    ) {
        Text(text = "Click me!")
    }
}

//2 -Filled Tonal
@Composable
fun FilledTonal(onCLick: () -> Unit) {
    FilledTonalButton(onClick = { onCLick() }) {
        Text(text = "FilledTonalButton")
    }
}

//3-Elevated Button
@Composable
fun ElevatedButton(onCLick: () -> Unit) {
    ElevatedButton(
        onClick = { onCLick() },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp) // 버튼의 그림자 높이 설정
    ) {
        Text(text = "ElevatedButton")
    }
}

//4-Outlined Button
@Composable
fun OutLinedButton(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("OutLinedButton")
    }
}

//5-Text Button
@Composable
fun TextButton(onClick: () -> Unit) {
    TextButton(onClick = { onClick() }) {
        Text("TextButton")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    FilledButton({ Log.v("TAGV", "클릭") })

}