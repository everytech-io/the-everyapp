package io.everytech.everyapp

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import io.everytech.everyapp.ui.screens.AppStoreScreen
import io.everytech.everyapp.ui.theme.EveryAppTheme

@Composable
@Preview
fun App() {
    EveryAppTheme {
        AppStoreScreen()
    }
}