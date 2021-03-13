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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

private val Kulim = FontFamily(
    Font(R.font.kulim_l, FontWeight.Light),
    Font(R.font.kulim_r, FontWeight.Normal),
)

private val Lato = FontFamily(
    Font(R.font.lato_r, FontWeight.Normal),
    Font(R.font.lato_b, FontWeight.Bold),
)

// Set of Material typography styles to start with
val typography = Typography(

    h1 = TextStyle(
        fontSize = 28.sp,
        letterSpacing = 1.15.sp,
        fontFamily = Kulim,
        fontWeight = FontWeight.Light
    ),

    h2 = TextStyle(
        fontSize = 15.sp,
        letterSpacing = 1.15.sp,
        fontFamily = Kulim,
        fontWeight = FontWeight.Normal
    ),

    h3 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontFamily = Lato,
        fontWeight = FontWeight.Bold
    ),

    button = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
    ),

    caption = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 1.15.sp,
        fontFamily = Lato,
        fontWeight = FontWeight.Normal
    ),

    body1 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontFamily = Lato,
        fontWeight = FontWeight.Normal
    ),

        /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
