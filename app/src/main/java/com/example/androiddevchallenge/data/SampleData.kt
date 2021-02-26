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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

class SampleData {
    companion object {
        val puppies = listOf(
            Puppy(
                "Bonnie",
                R.drawable.dog1,
                "Husky & German Shepherd Dog Mix",
                "Humboldt, SK",
                "Adult",
                "Female"
            ),
            Puppy(
                "Percy",
                R.drawable.dog2,
                " Labrador Retriever & Border Collie Mix",
                "Anchorage, AK",
                "Puppy",
                "Male"
            ),
            Puppy(
                "Jinx",
                R.drawable.dog3,
                "Labrador Retriever Mix",
                "Yellowknife, NT",
                "Adult",
                "Female"
            ),
            Puppy(
                "Hank",
                R.drawable.dog4,
                " Labrador Retriever Mix",
                "Kenai, AK",
                "Senior",
                "Male"
            ),
            Puppy(
                "Max Max",
                R.drawable.dog5,
                "German Shepherd Dog",
                "Yellowknife, NT",
                "Adult",
                "Male"
            ),
            Puppy(
                "Lily",
                R.drawable.dog6,
                " Chihuahua",
                "Soldotna, AK",
                "Adult",
                "Female"
            ),
            Puppy(
                "Clark",
                R.drawable.dog7,
                "German Shepherd Dog & Boxer Mix",
                "Edmonton, AB",
                "Puppy",
                "Male"
            ),
        )
    }
}
