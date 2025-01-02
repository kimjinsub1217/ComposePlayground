package com.jinsub.radiobutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinsub.radiobutton.ui.theme.RadioButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RadioButtonEx()
        }
    }
}

@Composable
fun RadioButtonEx() {
    var selectedOption by remember {
        mutableStateOf("Option 1")
    }

//    Column {
//        RadioButton(
//            selected = selectedOption == "Option 1",
//            onClick = { selectedOption = "Option 1" }
//        )
//
//        RadioButton(
//            selected = selectedOption == "Option 2",
//            onClick = { selectedOption = "Option 2" }
//        )
//
//        RadioButton(
//            selected = selectedOption == "Option 3",
//            onClick = { selectedOption = "Option 3" }
//        )
//    }

    Column {
        RadioButtonRowEx(
            "Option 1",
            selectedOption == "Option 1",
            { selectedOption = "Option 1" }
        )
        RadioButtonRowEx(
            "Option 2",
            selectedOption == "Option 2",
            { selectedOption = "Option 2" }
        )
        RadioButtonRowEx(
            "Option 3",
            selectedOption == "Option 3",
            { selectedOption = "Option 3" }
        )
    }
}

@Composable
fun RadioButtonRowEx(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = isSelected,
            onClick = onSelected,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(text = text)
    }
}
