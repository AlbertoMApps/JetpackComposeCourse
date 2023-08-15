package com.alberto.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alberto.compose.ui.messages
import com.alberto.compose.ui.screens.compose_essentials.Conversation
import com.alberto.compose.ui.screens.compose_essentials.MyApp
import com.alberto.compose.ui.screens.compose_essentials.MySootheApp
import com.alberto.compose.ui.screens.compose_essentials.WellnessScreen
import com.alberto.compose.ui.screens.material_design.ReplyApp
import com.alberto.compose.ui.screens.material_design.ReplyHomeViewModel
import com.alberto.compose.ui.screens.material_design.homeAnimation.Home
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Compose essentials
                    //1. First composable method
                    Conversation(messages = messages)
                    //2. Codelab for composable
                    MyApp(modifier = Modifier.fillMaxSize())
                    //3.Code lab for Basic layouts in Compose - MySootheApp
                    MySootheApp()
                    //4 State in Jetpack compose.
                    WellnessScreen()

                    //Material design, layouts, theming and animation
                    val viewModel: ReplyHomeViewModel by viewModels()
                    val uiState by viewModel.uiState.collectAsState()

                    Surface(
                        tonalElevation = 5.dp
                    ) {
                        ReplyApp(
                            replyHomeUIState = uiState,
                            closeDetailScreen = {
                                viewModel.closeDetailScreen()
                            },
                            navigateToDetail = { emailId ->
                                viewModel.setSelectedEmail(emailId)
                            }
                        )
                    }

                    Home()
                }
            }
        }
    }
}


