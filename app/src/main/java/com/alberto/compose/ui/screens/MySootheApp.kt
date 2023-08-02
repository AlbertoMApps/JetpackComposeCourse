package com.alberto.compose.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.compose.R
import com.alberto.compose.ui.messages
import com.alberto.compose.ui.theme.JetpackComposeCourseTheme
import java.util.Locale

@Composable
fun SearchBar(
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(stringResource(id = R.string.show_more))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
    )
}

@Preview
@Composable
private fun PreviewSearchBar() {
    JetpackComposeCourseTheme {
        SearchBar(
            modifier = Modifier
                .heightIn(56.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewAlignYourBodyElement() {
    JetpackComposeCourseTheme {
        AlignYourBodyElement(
            drawable = androidx.core.R.drawable.ic_call_answer,
            text = R.string.app_name,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavouriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewFavouriteCollectionCard() {
    JetpackComposeCourseTheme {
        FavouriteCollectionCard(
            drawable = androidx.core.R.drawable.ic_call_answer_video,
            text = R.string.app_name,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp) //content padding will not cut the items inside the content, different to the modifier one.
    ) {
        items(messages) { item ->
            AlignYourBodyElement(
                drawable = item.drawableRes,
                text = item.stringRes
            )
        }
    }

}

@Preview
@Composable
private fun PreviewAlignYourBodyRow() {
    JetpackComposeCourseTheme {
        AlignYourBodyRow(
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavouriteCollectionsGrid() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp),
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(messages) { item ->
            FavouriteCollectionCard(
                drawable = item.drawableRes,
                text = item.stringRes
            )
        }
    }

}

@Preview
@Composable
private fun PreviewFavouriteCollectionsGrid() {
    JetpackComposeCourseTheme {
        FavouriteCollectionsGrid()
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview
@Composable
fun HomeSectionPreview() {
    JetpackComposeCourseTheme {
        HomeSection(
            R.string.app_name,
            Modifier.padding(16.dp)
        ) {
            AlignYourBodyRow()
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        HomeSection(title = R.string.app_name) {
            AlignYourBodyRow()

        }
        HomeSection(title = R.string.show_more) {
            FavouriteCollectionsGrid()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF073042,
    heightDp = 18
)
@Composable
fun HomeScreenPreview() {
    JetpackComposeCourseTheme {
        HomeScreen()
    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            selected = true,
            icon = {
                Icon(imageVector = Icons.Default.Spa, contentDescription = null)
            },
            label = {
                Text(text = stringResource(R.string.home))
            },
            onClick = { /*TODO*/ })

        BottomNavigationItem(
            selected = true,
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = stringResource(R.string.profile))
            },
            onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    JetpackComposeCourseTheme {
        SootheBottomNavigation(
            Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun MySootheApp() {
    Scaffold(
        bottomBar = { SootheBottomNavigation() }
    ) { padding ->
        HomeScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePreview() {
    JetpackComposeCourseTheme {
        MySootheApp()
    }
}
