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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import java.util.Locale

val yogaItems = arrayListOf(
    AlignBodyOrMindItem("Inversions", R.drawable.yoga1),
    AlignBodyOrMindItem("Quick yoga", R.drawable.yoga2),
    AlignBodyOrMindItem("Stretching", R.drawable.yoga3),
    AlignBodyOrMindItem("Tabata", R.drawable.yoga4),
    AlignBodyOrMindItem("HIIT", R.drawable.yoga5),
    AlignBodyOrMindItem("Pre-natal yoga", R.drawable.yoga6),
)

val mindItems = arrayListOf(
    AlignBodyOrMindItem("Meditade", R.drawable.mind1),
    AlignBodyOrMindItem("With kids", R.drawable.mind2),
    AlignBodyOrMindItem("Aromatherapy", R.drawable.mind3),
    AlignBodyOrMindItem("On the go", R.drawable.mind4),
    AlignBodyOrMindItem("With pets", R.drawable.mind5),
    AlignBodyOrMindItem("High stress", R.drawable.mind6),
)

@Composable
fun AlignBodyMindList(
    modifier: Modifier = Modifier,
    label: String,
    yogaBodyOfMindList: List<AlignBodyOrMindItem>
) {
    Text(
        modifier = modifier
            .padding(top = 8.dp)
            .paddingFromBaseline(top = 40.dp),
        style = MaterialTheme.typography.h2,
        text = label.toUpperCase(Locale.getDefault())
    )

    LazyRow {
        items(yogaBodyOfMindList) { item ->
            AlignBodyMind(item = item)
        }
    }
}

@Composable
fun AlignBodyMind(item: AlignBodyOrMindItem) {
    Column(
        Modifier
            .padding(vertical = 4.dp)
            .padding(end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            painter = painterResource(item.drawableId),
            contentDescription = item.label,
            contentScale = ContentScale.FillBounds
        )

        Text(
            modifier = Modifier.paddingFromBaseline(top = 24.dp),
            text = item.label,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
@Preview
fun YogaItemPreview() {
    AlignBodyMind(item = yogaItems[0])
}

data class AlignBodyOrMindItem(
    val label: String,
    @DrawableRes val drawableId: Int
)
