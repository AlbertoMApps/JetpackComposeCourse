package com.alberto.compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier) {
        StatefulCounter()
//Since we use the view model state, we won't need the state list here
//        val list = remember {
//            getWellnessTasks().toMutableStateList()
//        }
//        val list = remember {
//            mutableListOf<WellnessTask>().apply {
//                addAll(getWellnessTasks())
//            }
//        }

        WellnessTaskList(modifier = modifier, wellnessViewModel.tasks) { task ->
            wellnessViewModel.remove(task)
        }
    }

}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WellnessScreenTest() {
    JetpackComposeCourseTheme {
        WellnessScreen()
    }
}