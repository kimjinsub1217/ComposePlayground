package com.jinsub.layout1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyRow()
//            myColumn()
//            MyBox()
//            MySurface()
            val snackbarHostState = remember { SnackbarHostState() }
            val coroutineScope = rememberCoroutineScope()
// 레이아웃 구조를 제공하는 컨테이너 ex) TopAppBar, BottomAppbar, FAB
            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackbarHostState
                    )
                },
                topBar = {
                    MyTopAppBar(
                        snackbarHostState = snackbarHostState,
                        coroutineScope = coroutineScope
                    )
                },
                bottomBar = {
                    MyBottomAppBar(
                        snackbarHostState = snackbarHostState,
                        coroutineScope = coroutineScope
                    )
                },
                floatingActionButton = {
                    MyFAB(
                        snackbarHostState = snackbarHostState,
                        coroutineScope = coroutineScope
                    )
                }
            ) {
                MyColumn()
            }
        }
    }
}

// 수평
@Composable
fun MyRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()//가로와 세로 방향으로 모두 최대 크기를 차지
    ) {
        Text(text = "25년 1월 3일")
        Text(text = "눈이 펑펑 내립니다..")
        Text(text = "저녁은 삼겹살~")
    }
}

/*
. horizontalArrangement
Row에서 자식 컴포넌트 간의 수평 간격을 설정합니다.
옵션은 Arrangement.Horizontal 타입입니다.

옵션	설명
Arrangement.Start	자식 컴포넌트를 Row의 왼쪽으로 정렬합니다.
Arrangement.Center	자식 컴포넌트를 가로 방향 중앙에 배치합니다.
Arrangement.End	자식 컴포넌트를 Row의 오른쪽으로 정렬합니다.
Arrangement.SpaceEvenly	자식 간의 간격과 좌우 여백을 동일하게 설정합니다.
Arrangement.SpaceBetween	자식 간의 간격은 동일하나, 좌우 끝에는 여백이 없습니다.
Arrangement.SpaceAround	자식 간의 간격이 동일하며, 좌우 여백은 간격의 절반으로 설정됩니다.

2. verticalAlignment
Row에서 자식 컴포넌트의 수직 정렬을 설정합니다.
옵션은 Alignment.Vertical 타입입니다.

옵션	설명
Alignment.Top	모든 자식 컴포넌트를 Row의 상단에 정렬합니다.
Alignment.CenterVertically	모든 자식 컴포넌트를 세로 방향 중앙에 정렬합니다.
Alignment.Bottom	모든 자식 컴포넌트를 Row의 하단에 정렬합니다.
 */

// 수직
@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()//가로와 세로 방향으로 모두 최대 크기를 차지

    ) {
        Text(text = "25년 1월 3일")
        Text(text = "눈이 펑펑 내립니다..")
        Text(text = "저녁은 삼겹살~")
    }
}
/*
1. horizontalAlignment
Column에서 자식 컴포넌트의 수평 정렬을 지정합니다.
옵션은 Alignment.Horizontal 타입입니다.

옵션	설명
Alignment.Start	왼쪽 정렬. 모든 자식이 Column의 왼쪽 가장자리에 배치됩니다.
Alignment.CenterHorizontally	가운데 정렬. 모든 자식이 수평 방향으로 Column의 중앙에 배치됩니다.
Alignment.End	오른쪽 정렬. 모든 자식이 Column의 오른쪽 가장자리에 배치됩니다.

2. verticalArrangement
Column에서 자식 컴포넌트 간의 수직 간격을 지정합니다.
옵션은 Arrangement.Vertical 타입입니다.

옵션	설명
Arrangement.Top	모든 자식이 Column의 상단에 정렬됩니다.
Arrangement.Center	모든 자식이 수직 방향으로 Column의 중앙에 정렬됩니다.
Arrangement.Bottom	모든 자식이 Column의 하단에 정렬됩니다.
Arrangement.SpaceEvenly	자식 컴포넌트 간의 간격과 상·하단 여백을 동일하게 설정합니다.
Arrangement.SpaceBetween	자식 컴포넌트 간의 간격은 동일하나, 시작(상단)과 끝(하단)의 여백은 없습니다.
Arrangement.SpaceAround	자식 컴포넌트 간의 간격이 동일하고, 상단·하단 여백은 간격의 절반으로 설정됩니다.
 */

// 자식 뷰를 위에 쌓는 방식
@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "25년 1월 3일",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "눈이 펑펑 내립니다..",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "저녁은 삼겹살~",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

// 배경, 모양, 그림자, 간격을 설정
@Composable
fun MySurface() {
    Surface(
        modifier = Modifier.size(500.dp),
        color = Color.Green,
        contentColor = colorResource(id = R.color.purple_700),
        shadowElevation = 1.dp,
        border = BorderStroke(1.dp, Color.Red)

    ) {
        MyColumn()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    TopAppBar(
        title = { Text(text = "Top App Bar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Cyan,
            titleContentColor = Color.Magenta
        ),
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("메뉴") // Snackbar 표시
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "메뉴"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("셋팅") // Snackbar 표시
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_build_24),
                    contentDescription = "셋팅"
                )
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBottomAppBar(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    BottomAppBar(
        containerColor = Color.Magenta,
        contentColor = Color.Cyan
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("홈") // Snackbar 표시
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "홈"
                )
            }

            IconButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("북마크") // Snackbar 표시
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_collections_bookmark_24),
                    contentDescription = "북마크"
                )
            }

            IconButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("사람") // Snackbar 표시
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_people_24),
                    contentDescription = "사람"
                )
            }
        }
    }
}

@Composable
fun MyFAB(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                snackbarHostState.showSnackbar("FAB") // Snackbar 표시
            }
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = "FAB ADD"
        )
    }
}