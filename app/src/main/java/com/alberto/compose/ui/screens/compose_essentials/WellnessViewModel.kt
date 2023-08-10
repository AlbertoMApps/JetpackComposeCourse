package com.alberto.compose.ui.screens.compose_essentials

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.alberto.compose.ui.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }