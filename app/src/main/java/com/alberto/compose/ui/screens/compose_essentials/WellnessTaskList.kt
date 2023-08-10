package com.alberto.compose.ui.screens.compose_essentials

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alberto.compose.ui.WellnessTask

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(list, key = { task -> task.id }) { task ->
            WellnessTaskItemStateful(
                taskName = task.label,
                modifier = modifier,
                onCloseTask = { onCloseTask(task) })
        }
    }
}

