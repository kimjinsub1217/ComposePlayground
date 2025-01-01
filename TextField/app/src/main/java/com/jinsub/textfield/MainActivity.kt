package com.jinsub.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.jinsub.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTextField()
        }
    }
}

//TextField

@Composable
fun MyTextField() {

    // by: 특정 객체에 기능을 위임하거나 속성을 간편하게 사용할 수 있도록 도와주는 키워드
    var text by remember { // 상태기억
        mutableStateOf(TextFieldValue()) // 상태 변화 관찰 , 텍스트 필트의 값 관리
    }

    TextField(
        value = text, // TextField가 현재 표시할 텍스트 값을 나타냅니다.
        onValueChange  = { newValue -> //텍스트 필드의 내용이 변경될 때 호출되는 콜백 함수입니다.
            text = newValue
        }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldTheme {

    }
}