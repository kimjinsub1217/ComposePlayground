package com.jinsub.checkbox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jinsub.checkbox.ui.theme.CheckBoxTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxEx()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckBoxEx() {

    var checked by remember {
        mutableStateOf(false)
    }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // SnackbarHost 설정
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { isChecked ->
                checked = isChecked
                if (checked) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("체크") // Snackbar 표시
                    }
                } else {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("체크 해제")
                    }
                }

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckBoxTheme {
        CheckBoxEx()
    }
}