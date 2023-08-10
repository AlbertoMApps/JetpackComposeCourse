package com.alberto.compose.ui.screens.compose_essentials

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {//count needs to recompose by remembering the state of the value
        mutableStateOf(value = 0)
    }
//    var juiceCount by rememberSaveable {//count needs to recompose by remembering the state of the value
//        mutableStateOf(value = 0)
//    }
    //------ Stateless -  state hoisting
    StatelessCounter(modifier = modifier, onIncrement = { count++ }, count = count)
//    StatelessCounter(modifier = modifier, onIncrement = { juiceCount++ }, count = juiceCount)

}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WaterCounterTest() {
    JetpackComposeCourseTheme {
        StatefulCounter()
    }
}

@Composable
private fun StatelessCounter(
    modifier: Modifier = Modifier,
    onIncrement: () -> Unit,
    count: Int
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses"
            )
        }
        Button(
            onClick = { onIncrement() },
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }
}

