package com.app.sharedelementsdebug.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.sharedelementsdebug.transitionDuration
import com.app.sharedelementsdebug.ui.navigation.AppScreen
import com.app.sharedelementsdebug.ui.shared_elements.SharedElement
import com.app.sharedelementsdebug.ui.shared_elements.SharedElementsTransitionSpec

@Composable
fun DetailScreen(
    id: String
) {
    LaunchedEffect(Unit) {
        Log.v("Navigation", "Navigated to $id")
    }
    SharedElement(
        key = "$id/Container",
        screenKey = AppScreen.Detail.route,
        transitionSpec = SharedElementsTransitionSpec(
            durationMillis = transitionDuration
        )
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colors.surface,
            elevation = 1.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                SharedElement(
                    key = "$id/author",
                    screenKey = AppScreen.Detail.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Author: Author name")
                }

                SharedElement(
                    key = "$id/subject",
                    screenKey = AppScreen.Detail.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Subject: Subject name")
                }

                SharedElement(
                    key = "$id/description",
                    screenKey = AppScreen.Detail.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Description: description")
                }

                SharedElement(
                    key = "$id/whatever",
                    screenKey = AppScreen.Detail.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Whatever idk")
                }

            }
        }
    }
}