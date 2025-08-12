package io.everytech.everyapp.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import io.everytech.everyapp.ui.components.EveryEmptyState
import io.everytech.everyapp.ui.config.EveryEmptyStateConfig
import io.everytech.everyapp.ui.config.EveryTextFieldConfig
import io.everytech.everyapp.ui.config.QuickActionConfig

@Composable
fun AppStoreScreen(
    modifier: Modifier = Modifier
) {
    var userApps by remember { mutableStateOf<List<Any>>(emptyList()) }
    var appDescription by remember { mutableStateOf("") }
    
    if (userApps.isEmpty()) {
        EveryEmptyState(
            config = EveryEmptyStateConfig(
                title = "Welcome to EveryApp!",
                subtitle = "Your AI-powered low-code platform",
                textFieldConfig = EveryTextFieldConfig(
                    placeholder = "Describe the app you want to build...",
                    value = appDescription
                ),
                quickActions = listOf(
                    QuickActionConfig(
                        label = "E-commerce App",
                        onClick = {
                            appDescription = "I want to build an e-commerce app with product listings, shopping cart, and checkout"
                        }
                    ),
                    QuickActionConfig(
                        label = "Social Platform",
                        onClick = {
                            appDescription = "I want to create a social media platform with user profiles and messaging"
                        }
                    ),
                    QuickActionConfig(
                        label = "Task Manager",
                        onClick = {
                            appDescription = "I need a task management app with projects, deadlines, and team collaboration"
                        }
                    )
                ),
                showIcon = true,
                iconEmoji = "🚀"
            ),
            onTextChange = { newText ->
                appDescription = newText
            },
            modifier = modifier
        )
    } else {
        // TODO: Show app grid when user has apps
    }
}