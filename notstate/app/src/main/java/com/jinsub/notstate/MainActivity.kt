package com.jinsub.notstate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.jinsub.notstate.ui.theme.NotstateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counter()
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun Counter() {
    var count = remember {
        mutableIntStateOf(0)
    }
    Column {
        Text("Counter : ${count.intValue}")
        Button(onClick = { count.intValue++ }) {
            Text(text = "Counter 증가")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotstateTheme {

    }
}