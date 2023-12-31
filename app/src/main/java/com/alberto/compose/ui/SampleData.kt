package com.alberto.compose.ui

import com.alberto.compose.R

val messages = listOf(
    Message(
        "Alberto",
        "Jetpack compose",
        androidx.core.R.drawable.ic_call_answer,
        R.string.app_name
    ),
    Message(
        "Example",
        "Jetpack compose",
        androidx.core.R.drawable.ic_call_answer_video,
        R.string.app_name
    )
)

data class Message(
    val author: String,
    val body: String,
    val drawableRes: Int = androidx.core.R.drawable.ic_call_answer,
    val stringRes: Int = R.string.app_name
)
