package com.jinsub.lists

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ScrollingColumn()
//            ScrollingRow()
            MyLazyColumn()
//            MyLazyRow()
        }
    }
}

@Composable
fun ScrollingColumn() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "포켓몬 스칼렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "포켓몬 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "스타팅 포켓몬",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_4),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_5),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ScrollingRow() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "포켓몬 스칼렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "포켓몬 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "스타팅 포켓몬",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_4),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.img_5),
            contentDescription = "포켓몬 스칼렛 바이올렛",
            contentScale = ContentScale.FillBounds
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyLazyColumn() {
    LazyColumn {

        stickyHeader {
            Text(
                text = "stickyHeader",
                fontSize = 42.sp,
                modifier = Modifier.background(Color.Blue)
            )
        }

        item {
            Text(text = "Title", fontSize = 48.sp)
        }

        items(itemsList) { item ->
            MyCustomItem(itemTitle = item)
        }
    }
}

@Composable
fun MyCustomItem(itemTitle: String) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
//            .clickable {
//                Toast.makeText(
//                    context,
//                    "클릭 : $itemTitle",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = itemTitle,
            fontSize = 42.sp,
            modifier = Modifier
                .background(Color.Green)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            Toast
                                .makeText(
                                    context,
                                    "롱터치 :$itemTitle",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {

                    }
                }
        )
    }
}

@Composable
fun MyLazyRow() {
    LazyRow {
        items(itemsList) { item ->
            MyCustomItem(itemTitle = item)
        }
    }
}

val itemsList = listOf<String>(
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten"
)