/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import java.util.Locale

val favItems = arrayListOf(
    FavItem("Short mantras", R.drawable.card1),
    FavItem("Stress and anxiety", R.drawable.card2),
    FavItem("Overwhelmed", R.drawable.card3),
    FavItem("Nature medications", R.drawable.card4),
    FavItem("Self-message", R.drawable.card5),
    FavItem("Nightly wind down", R.drawable.card1),
)

@Composable
fun CardRows(label: String) {

    Column {
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp),
            text = label.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.h2
        )

        LazyRow {
            val windowedItems = favItems.windowed(2, step = 2, true)
            items(items = windowedItems) { windowItem ->
                VerticalFavoriteCard(item = windowItem)
            }
        }
    }
}

@Composable
fun VerticalFavoriteCard(item: List<FavItem>) {
    Column {
        item.forEach {
            FavoriteCard(item = it)
        }
    }
}

@Composable
fun FavoriteCard(item: FavItem) {

    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .padding(end = 8.dp)
            .size(width = 192.dp, height = 56.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(56.dp, 56.dp),
                painter = painterResource(item.cardImage),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = item.label,
                style = MaterialTheme.typography.h3,
            )
        }
    }
}

@Composable
@Preview
fun FavoriteCardPreview() {
    FavoriteCard(item = favItems[0])
}

data class FavItem(
    val label: String,
    @DrawableRes val cardImage: Int,
)
