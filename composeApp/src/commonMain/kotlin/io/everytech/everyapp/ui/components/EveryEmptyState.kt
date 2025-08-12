package io.everytech.everyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.everytech.everyapp.ui.config.EveryButtonConfig
import io.everytech.everyapp.ui.config.EveryEmptyStateConfig

@Composable
fun EveryEmptyState(
    config: EveryEmptyStateConfig,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var textValue by remember { mutableStateOf(config.textFieldConfig.value) }
    
    val backgroundColor = config.backgroundColor ?: MaterialTheme.colorScheme.background
    
    val titleColor = config.titleColor ?: MaterialTheme.colorScheme.onBackground
    
    val subtitleColor = config.subtitleColor ?: MaterialTheme.colorScheme.onSurfaceVariant
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Main content area (scrollable)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)
                .padding(top = 48.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            
            if (config.showIcon) {
                Text(
                    text = config.iconEmoji,
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontSize = config.iconSize.value.sp
                    )
                )
                
                Spacer(modifier = Modifier.height(config.spacing))
            }
            
            Text(
                text = config.title,
                style = config.titleStyle.copy(color = titleColor)
            )
            
            if (config.subtitle.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = config.subtitle,
                    style = config.subtitleStyle.copy(color = subtitleColor)
                )
            }
            
            if (config.quickActions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(config.spacing * 2))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
                ) {
                    config.quickActions.forEach { action ->
                        EveryButton(
                            config = EveryButtonConfig(
                                text = action.label
                            ),
                            onClick = action.onClick
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(120.dp))
        }
        
        // Bottom input area (fixed at bottom)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp, top = 16.dp)
        ) {
            EveryTextField(
                config = config.textFieldConfig.copy(value = textValue),
                onValueChange = { newValue ->
                    textValue = newValue
                    onTextChange(newValue)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}