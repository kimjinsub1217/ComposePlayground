package com.jinsub.aswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jinsub.aswitch.ui.theme.SwitchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CheckBoxEx()
        }
    }
}

@Composable
fun CheckBoxEx() {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}