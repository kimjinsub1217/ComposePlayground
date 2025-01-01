package com.jinsub.compos1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinsub.compos1.ui.theme.Compos1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compos1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .border(6.dp,Color.Magenta)
    ) {  // 수직 목록
        Text(
            text = "Hello Android",
            color = Color.Cyan,// 색상
            fontStyle = FontStyle.Italic,//글꼴 스타일
            fontFamily = FontFamily.Cursive,//글꼴 모음
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            ), // 텍스트 장식
            textAlign = TextAlign.Center //텍스트 정렬
        )
        Text(
            text = "안녕하세요"
        )

    }
//    Row(modifier = Modifier.padding(16.dp)) {  // 수평 목록
//        Text(
//            text = "Hello Android",
//            color = Color.Cyan,// 색상
//            fontStyle = FontStyle.Italic,//글꼴 스타일
//            fontFamily = FontFamily.Cursive,//글꼴 모음
//            textDecoration = TextDecoration.combine(
//                listOf(
//                    TextDecoration.LineThrough,
//                    TextDecoration.Underline
//                )
//            ), // 텍스트 장식
//            textAlign = TextAlign.Center //텍스트 정렬
//        )
//        Text(
//            text = "안녕하세요"
//        )
//
//    }

//    Box(modifier = Modifier.padding(16.dp)) {  // 여러 위젯를 겹쳐서 놓을 수 있는 레이아웃
//        Text(
//            text = "Hello Android",
//            color = Color.Cyan,// 색상
//            fontStyle = FontStyle.Italic,//글꼴 스타일
//            fontFamily = FontFamily.Cursive,//글꼴 모음
//            textDecoration = TextDecoration.combine(
//                listOf(
//                    TextDecoration.LineThrough,
//                    TextDecoration.Underline
//                )
//            ), // 텍스트 장식
//            textAlign = TextAlign.Center //텍스트 정렬
//        )
//        Text(
//            text = "안녕하세요"
//        )
//
//    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compos1Theme {
        Greeting("Android")
    }
}