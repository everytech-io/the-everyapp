package io.everytech.everyapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.everytech.everyapp.data.EveryAppData
import io.everytech.everyapp.service.MockAPIService
import io.everytech.everyapp.ui.components.EveryEmptyState
import io.everytech.everyapp.ui.components.EveryAppRenderer
import io.everytech.everyapp.ui.config.EveryEmptyStateConfig
import io.everytech.everyapp.ui.config.EveryTextFieldConfig
import io.everytech.everyapp.ui.config.QuickActionConfig
import kotlinx.coroutines.launch

@Composable
fun AppStoreScreen(
    modifier: Modifier = Modifier
) {
    var appDescription by remember { mutableStateOf("") }
    var generatedApp by remember { mutableStateOf<EveryAppData?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val apiService = remember { MockAPIService() }
    val scope = rememberCoroutineScope()
    
    when {
        generatedApp != null -> {
            // Show generated M3 Expressive app
            Column(modifier = modifier.fillMaxSize()) {
                // Top bar with back button
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { 
                            generatedApp = null
                            appDescription = ""
                        }
                    ) {
                        Text("← Back")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = generatedApp!!.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                // Render the M3 Expressive app
                EveryAppRenderer(
                    app = generatedApp!!,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        isLoading -> {
            // Show loading state
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CircularProgressIndicator()
                    Text(
                        text = "Generating your app...",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "This may take a few moments",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        else -> {
            // Show empty state with prompt input
            EveryEmptyState(
                config = EveryEmptyStateConfig(
                    title = "Welcome to EveryApp!",
                    subtitle = "Your AI-powered low-code platform",
                    textFieldConfig = EveryTextFieldConfig(
                        placeholder = "Describe the app you want to build...\n\nTry: 'calorie tracker', 'ecommerce store', 'banking app', 'music player', 'recipe app'",
                        value = appDescription,
                        minHeight = 120.dp,
                        maxLines = 5
                    ),
                    quickActions = listOf(
                        QuickActionConfig(
                            label = "Calorie Tracker",
                            onClick = {
                                appDescription = "Create a calorie tracker app with meal logging and progress tracking"
                            }
                        ),
                        QuickActionConfig(
                            label = "E-commerce Store",
                            onClick = {
                                appDescription = "Build an ecommerce store with product catalog and shopping cart"
                            }
                        ),
                        QuickActionConfig(
                            label = "Banking App",
                            onClick = {
                                appDescription = "Design a banking app with account balance and transactions"
                            }
                        ),
                        QuickActionConfig(
                            label = "Music Player",
                            onClick = {
                                appDescription = "Make a music player with playlists and streaming"
                            }
                        )
                    ),
                    showIcon = true,
                    iconEmoji = "🚀",
                    onGenerate = {
                        if (appDescription.trim().length > 5 && !isLoading) {
                            scope.launch {
                                isLoading = true
                                try {
                                    val app = apiService.generateUIFromPrompt(appDescription)
                                    generatedApp = app
                                } catch (e: Exception) {
                                    // Handle error
                                } finally {
                                    isLoading = false
                                }
                            }
                        }
                    }
                ),
                onTextChange = { newText ->
                    appDescription = newText
                },
                modifier = modifier
            )
        }
    }
}