package com.app.sharedelementsdebug.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.sharedelementsdebug.transitionDuration
import com.app.sharedelementsdebug.ui.navigation.AppScreen
import com.app.sharedelementsdebug.ui.shared_elements.SharedElement
import com.app.sharedelementsdebug.ui.shared_elements.SharedElementsTransitionSpec

@Composable
fun ListScreen(navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = listOf("a", "b", "c", "d", "e"),
            key = {it}
        ) {
            SharedElement(
                key = "$it/Container",
                screenKey = AppScreen.List.route,
                transitionSpec = SharedElementsTransitionSpec(
                    durationMillis = transitionDuration
                )
            ) {
                SharedCard(key = it) {
                    Log.v("Navigation", "Navigation to $it")
                    navController.navigate("${AppScreen.Detail.navLink}/$it")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SharedCard(
    key: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 8.dp,
                    start = 15.dp,
                    end = 15.dp
                )
        ) {
            Text(
                text = "Card title",
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                SharedElement(
                    key = "$key/author",
                    screenKey = AppScreen.List.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Author name")
                }

                SharedElement(
                    key = "$key/subject",
                    screenKey = AppScreen.List.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("Subject name")
                }

                SharedElement(
                    key = "$key/description",
                    screenKey = AppScreen.List.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("description")
                }

                SharedElement(
                    key = "$key/whatever",
                    screenKey = AppScreen.List.route,
                    transitionSpec = SharedElementsTransitionSpec(
                        durationMillis = transitionDuration
                    )
                ) {
                    Text("idk")
                }
            }
        }
    }
}