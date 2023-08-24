package com.alberto.compose.ui.home

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme

@Composable
fun MainScreen(onExploreItemClicked: OnExploreItemClicked) {
    Surface(color = MaterialTheme.colors.primary) {
        var showLandingScreen by remember { mutableStateOf(true) }
        if (showLandingScreen) {
            LandingScreen(onTimeout = { showLandingScreen = false })
        } else {
            CraneHome(onExploreItemClicked = onExploreItemClicked)
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "MainScreen"
)
@Composable
fun MainScreenPreviewLight() {
    JetpackComposeCourseTheme() {
        androidx.compose.material3.Surface(
            tonalElevation = 5.dp
        ) {
            CraneHome(onExploreItemClicked = { })
        }
    }
}