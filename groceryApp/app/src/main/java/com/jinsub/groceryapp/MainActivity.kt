package com.jinsub.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinsub.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnWithStickyHeader()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithStickyHeader() {
    val groupedItems = mapOf(
        "라면" to listOf(
            Item("신라면", "사나이 울리는 신라면", R.drawable.img),
            Item("육개장", "근본 사발면", R.drawable.img_1),
            Item("불닭볶음면", "엄청 매운 라면", R.drawable.img_2),
            Item("너구리", "너구리 한마리 몰고 가세요", R.drawable.img_3),
            Item("짜파게티", "일요일 요리사", R.drawable.img_4),
            Item("팔도비빔면", "삼겹살이랑 같이 먹으면 맛있는 라면", R.drawable.img_5),
            Item("왕뚜껑", "왕뚜껑", R.drawable.img_6),
            Item("안성탕면", "그냥 삼양라면", R.drawable.img_7),
            Item("참깨라면", "계란 블럭이 맛잇는 라면 고소하다", R.drawable.img_8),
            Item("짜파게티범벅", "양은 적지만 매우 맛있다.", R.drawable.img_9),

            ),
        "과자"
                to listOf(
            Item("프링글스", "초록 프링글스가 맛있는 과자", R.drawable.img_10),
            Item("포카칩", "초록 포카칩이 맛있는 과자", R.drawable.img_11),
            Item("허니버터칩", "옛날에 유행한 과자", R.drawable.img_12),
            Item("찹쌀선과", "초록색이 맛있는 과자", R.drawable.img_13),
            Item("홈런볼", "은근 칼로리가 높은 과자", R.drawable.img_14),
            Item("빼빼로", "초록색 아몬드 빼빼로가 맛있는 과자", R.drawable.img_15),
            Item("눈을 감자", "먹어 본적이 없는 과자", R.drawable.img_16),
            Item("태양의 맛 썬", "그냥 삼양라면", R.drawable.img_17),
            Item("오리온 초코파이", "정을 나누는 초코 과자", R.drawable.img_18),
            Item("초코송이", "맛있는 과자", R.drawable.img_19),

            )
    )
    val myRamens = groupedItems["라면"]

    LazyColumn {
        groupedItems.forEach { (header, items) ->
            stickyHeader {
                MyCustomHeader(title = header)
            }
            items(items) { item ->
                MyCustomItem(item)
            }
        }
    }
}

@Composable
fun MyCustomHeader(title: String) {
    Text(
        text = title,
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(8.dp)
    )
}

@Composable
fun MyCustomItem(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Item Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.title,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.desc,
                fontSize = 18.sp
            )
        }
    }
}