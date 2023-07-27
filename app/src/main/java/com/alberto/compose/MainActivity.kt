package com.alberto.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.alberto.compose.ui.messages
import com.alberto.compose.ui.screens.Conversation
import com.alberto.compose.ui.screens.MyApp
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
                    //1. First composable method
                    Conversation(messages = messages)
                    //2. Codelab for composable
                    MyApp(modifier = Modifier.fillMaxSize())
                    
                }
            }
        }
    }
}


