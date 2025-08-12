package io.everytech.everyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import io.everytech.everyapp.ui.config.EveryTextFieldConfig

@Composable
fun EveryTextField(
    config: EveryTextFieldConfig,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    
    val backgroundColor = config.backgroundColor ?: MaterialTheme.colorScheme.surfaceVariant
    
    val borderColor = when {
        isFocused -> config.focusedBorderColor ?: MaterialTheme.colorScheme.primary
        else -> config.borderColor ?: MaterialTheme.colorScheme.outline
    }
    
    val textColor = config.textColor ?: MaterialTheme.colorScheme.onSurface
    
    val placeholderColor = config.placeholderColor ?: MaterialTheme.colorScheme.onSurfaceVariant
    
    val cursorColor = config.cursorColor ?: MaterialTheme.colorScheme.primary
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = config.minHeight, max = config.maxHeight)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(config.cornerRadius)
            )
            .border(
                width = config.borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(config.cornerRadius)
            )
    ) {
        BasicTextField(
            value = config.value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(config.contentPadding)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            textStyle = config.textStyle.copy(color = textColor),
            singleLine = config.singleLine,
            maxLines = config.maxLines,
            enabled = config.enabled,
            readOnly = config.readOnly,
            cursorBrush = SolidColor(cursorColor),
            decorationBox = { innerTextField ->
                Box {
                    if (config.value.isEmpty()) {
                        Text(
                            text = config.placeholder,
                            style = config.placeholderStyle.copy(color = placeholderColor)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}