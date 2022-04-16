package com.app.sharedelementsdebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.app.sharedelementsdebug.ui.navigation.AppNavigation
import com.app.sharedelementsdebug.ui.shared_elements.SharedElementsRoot
import com.app.sharedelementsdebug.ui.theme.SharedElementsDebugTheme

val transitionDuration = 2000

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedElementsDebugTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SharedElementsRoot {
                        AppNavigation(rememberNavController())
                    }
                }
            }
        }
    }
}