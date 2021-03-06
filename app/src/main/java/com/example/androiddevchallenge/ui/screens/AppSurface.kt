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
package com.example.androiddevchallenge.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.components.BackgroundImage

@Composable
fun AppSurface(
    @DrawableRes backgroundDrawable: Int? = null,
    contentPadding: Dp = 16.dp,
    content: @Composable() () -> Unit,
) {
    Surface(color = MaterialTheme.colors.background) {

        backgroundDrawable?.let {
            Box(contentAlignment = Alignment.Center) {
                BackgroundImage(backgroundDrawable)
            }
        }

        Box(Modifier.padding(contentPadding)) {
            content()
        }
    }
}
