package com.jinsub.progress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinsub.progress.ui.theme.ProgressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                CircularProgressIndicatorEx()
                Spacer(modifier = Modifier.height(16.dp))
                LinearProgressIndicatorEx()
            }
        }
    }
}

@Composable
fun CircularProgressIndicatorEx() {
    CircularProgressIndicator(
        progress = { 0.7f },
    )
}

@Composable
fun LinearProgressIndicatorEx() {
    LinearProgressIndicator(
        progress = { 0.7f },
        color = Color.Cyan,
        trackColor = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.height(8.dp)
    )
}



