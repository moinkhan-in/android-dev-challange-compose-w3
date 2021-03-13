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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppEditText
import com.example.androiddevchallenge.ui.components.ButtonText
import java.util.Locale

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {

    AppSurface(backgroundDrawable = R.drawable.login) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.paddingFromBaseline(bottom = 32.dp),
                text = stringResource(id = R.string.login).toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.h1
            )

            AppEditText(
                modifier = Modifier.padding(bottom = 8.dp),
                hint = stringResource(R.string.hint_email_address),
                keyboardType = KeyboardType.Email
            )

            AppEditText(
                modifier = Modifier.padding(bottom = 8.dp),
                hint = stringResource(R.string.hint_password),
                keyboardType = KeyboardType.Password
            )

            ButtonText(text = stringResource(id = R.string.login), onClick = onLoginSuccess)

            Row {
                Text(
                    text = stringResource(R.string.no_account),
                    modifier = Modifier.paddingFromBaseline(top = 32.dp),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = stringResource(id = R.string.signup),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .paddingFromBaseline(top = 32.dp),
                    style = MaterialTheme.typography.body1,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}
