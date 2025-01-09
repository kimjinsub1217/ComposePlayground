package com.jinsub.constraint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (box1, box2, text) = createRefs()
        val guidLine1 = createGuidelineFromStart(0.2f)
        val barrier1 = createEndBarrier(box1, box2)
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(guidLine1)
                }
        )

        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color.Magenta)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom, margin = 20.dp)
                    start.linkTo(guidLine1)
                }
        )

        Text(
            text = "Hello Constraint Layout",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(box2.bottom, margin = 16.dp)
                start.linkTo(barrier1, margin = 16.dp)
            }
        )

        createVerticalChain(
            box1, box2,
            chainStyle = ChainStyle.Spread
        )
    }
}