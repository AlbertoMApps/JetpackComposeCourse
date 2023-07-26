package com.alberto.compose.ui.screens

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.compose.R
import com.alberto.compose.ui.messages
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme

/**
 * 1. This first composable Conversation method with MessageCard composable methods are based on the course of Jetpack Compose for Android Develpers
 * https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1
 */
@Composable
fun MessageCard(message: Message, modifier: Modifier = Modifier) {
    /**
     * Compose uses modifiers. They allow you to change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable. You can chain them to create richer composables. You'll use some of them to improve the layout.
     */
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
        )
    }
    Spacer(modifier = modifier)

    /**
     * The Column function lets you arrange elements vertically. Add Column to the MessageCard function.
    You can use Row to arrange items horizontally and Box to stack elements
     */

    // We keep track if the message is expanded or not in this
    // variable

    var isExpanded by remember { mutableStateOf(false) }

    // surfaceColor will be updated gradually from one color to the other
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
    )

    // We toggle the isExpanded variable when we click on this Column
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Text(
            text = message.author,
            modifier = modifier,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 1.dp,
            // surfaceColor color will be changing gradually from primary to surface
            color = surfaceColor,
            // animateContentSize will change the Surface size gradually
            modifier = Modifier
                .animateContentSize()
                .padding(1.dp)

        ) {
            Text(
                text = message.body,
                modifier = modifier,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Enable dark mode
 */
@Preview(showBackground = true, name = "Light mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode0"
)


@Composable
fun PreviewMessageCard() {
    JetpackComposeCourseTheme {
        Surface {
            MessageCard(
                message = Message("Alberto", "Hello Jetpack Compose"),
                modifier = Modifier.padding(all = 8.dp)
            )
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(
                message = message,
                modifier = Modifier.padding(all = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    JetpackComposeCourseTheme {
        Conversation(messages = messages)
    }
}

/**
 * Here’s what you've learned so far:

- Defining composable functions
- Adding different elements in your composable
- Structuring your UI component using layout composables
- Extending composables by using modifiers
- Creating an efficient list
- Keeping track of state and modifying it
- Adding user interaction on a composable
- Animating messages while expanding them
 */
