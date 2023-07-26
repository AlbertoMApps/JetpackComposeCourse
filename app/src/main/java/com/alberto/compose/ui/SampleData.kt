package com.alberto.compose.ui

val messages = listOf(
    Message("Alberto", "Jetpack compose"),
    Message("Example", "Jetpack compose")
)

data class Message(val author: String, val body: String)
