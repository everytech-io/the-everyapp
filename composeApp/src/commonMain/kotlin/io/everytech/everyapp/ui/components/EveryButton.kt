package io.everytech.everyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.everytech.everyapp.ui.config.EveryButtonConfig

@Composable
fun EveryButton(
    config: EveryButtonConfig,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when {
        !config.enabled -> config.disabledBackgroundColor ?: MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        else -> config.backgroundColor ?: MaterialTheme.colorScheme.secondaryContainer
    }
    
    val textColor = when {
        !config.enabled -> config.disabledTextColor ?: MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        else -> config.textColor ?: MaterialTheme.colorScheme.onSecondaryContainer
    }
    
    val borderColor = config.borderColor ?: MaterialTheme.colorScheme.outline
    
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(config.cornerRadius)
            )
            .border(
                width = config.borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(config.cornerRadius)
            )
            .clickable(enabled = config.enabled, onClick = onClick)
            .padding(config.contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = config.text,
            style = config.textStyle.copy(color = textColor)
        )
    }
}