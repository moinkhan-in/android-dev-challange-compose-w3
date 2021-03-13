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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppEditText
import com.example.androiddevchallenge.ui.screens.AppSurface
import java.util.Locale

@Composable
fun HomeScreen() {

    Scaffold(
        bottomBar = { BottomBar() },
        floatingActionButton = { BottomBarFloat() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {

        AppSurface(contentPadding = 0.dp) {
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 56.dp)
            ) {

                AppEditText(
                    Modifier.padding(end = 16.dp),
                    leadingIcon = { Icon(Icons.Filled.Search, null) },
                    hint = stringResource(R.string.search)
                )

                CardRows(label = stringResource(R.string.fav_collections))

                AlignBodyMindList(
                    label = stringResource(R.string.align_body),
                    yogaBodyOfMindList = yogaItems
                )

                AlignBodyMindList(
                    label = stringResource(R.string.align_mind),
                    yogaBodyOfMindList = mindItems
                )
            }
        }
    }
}

@Composable
fun BottomBar() {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile
    )
    val backColor = MaterialTheme.colors.background
    BottomNavigation(
        elevation = 8.dp,
        backgroundColor = backColor,
        contentColor = contentColorFor(backColor),
    ) {
        items.forEach { screen ->
            val label = stringResource(id = screen.label)
            BottomNavigationItem(
                // dummy selected
                selected = screen.isSelected,
                icon = { Icon(screen.icon, label) },
                label = {
                    Text(
                        text = label.toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.caption
                    )
                },
                onClick = { }
            )
        }
    }
}

@Composable
fun BottomBarFloat() {
    val backColor = MaterialTheme.colors.primary
    val contentColor = contentColorFor(backgroundColor = backColor)
    FloatingActionButton(onClick = { }, backgroundColor = backColor, contentColor = contentColor) {
        Icon(Icons.Filled.ArrowRight, contentDescription = null, Modifier.size(36.dp), tint = contentColor)
    }
}

sealed class BottomNavItem(@StringRes val label: Int, val icon: ImageVector, val isSelected: Boolean) {
    object Home : BottomNavItem(R.string.home, Icons.Filled.Spa, true)
    object Profile : BottomNavItem(R.string.profile, Icons.Filled.AccountCircle, false)
}
