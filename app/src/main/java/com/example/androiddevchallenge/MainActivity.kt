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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.SampleData
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    private val puppies = SampleData.puppies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyTheme {
                Navigate(navController)
            }
        }
    }

    @Composable
    fun Navigate(navController: NavHostController) {
        NavHost(navController, startDestination = "home") {
            composable("home") { MyApp(puppies, navController) }
            composable("puppy") { PuppyDetails(navController) }
        }
    }
}

@Composable
fun MyApp(puppies: List<Puppy>, navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background, elevation = 2.dp) {
        LazyColumn {
            items(items = puppies) { puppy ->
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(
                            onClick = {
                                navController.currentBackStackEntry?.arguments?.putSerializable(
                                    "puppy",
                                    puppy
                                )
                                navController.navigate("puppy")
                            }
                        ),
                    elevation = 4.dp
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = puppy.image),
                            contentDescription = null,
                            modifier = Modifier
                                .height(180.dp)
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(4.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(Modifier.size(16.dp))
                        Text(
                            text = puppy.name,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PuppyDetails(navController: NavHostController) {
    val puppy = navController.previousBackStackEntry?.arguments?.getSerializable("puppy") as? Puppy

    Card(modifier = Modifier.padding(16.dp), elevation = 4.dp) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = puppy?.image!!),
                contentDescription = null,
                modifier = Modifier
                    .height(360.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(16.dp))
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(bottom = 8.dp),
                fontFamily = FontFamily.Serif
            )
            Text(
                text = puppy.race,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily.Serif
            )
            Text(
                text = puppy.gender,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp),
                fontFamily = FontFamily.Serif
            )
            Text(
                text = puppy.age,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp),
                fontFamily = FontFamily.Serif
            )
            Text(
                text = puppy.place,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(bottom = 8.dp),
                fontFamily = FontFamily.Serif
            )
            Spacer(Modifier.size(8.dp))
            Button(modifier = Modifier.padding(bottom = 8.dp), onClick = {}) { Text("Adopt") }
        }
    }
}
