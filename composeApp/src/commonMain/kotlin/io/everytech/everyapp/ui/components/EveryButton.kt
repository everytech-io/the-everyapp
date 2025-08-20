package io.everytech.everyapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.everytech.everyapp.ui.config.EveryButtonConfig
import io.everytech.everyapp.ui.config.ButtonType
import io.everytech.everyapp.ui.config.ButtonSize
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Material 3 button component that supports multiple button variants.
 *
 * Supports the following button types:
 * - FILLED_BUTTON: High emphasis actions with filled background
 * - OUTLINED_BUTTON: Medium emphasis actions with outlined style
 * - TEXT_BUTTON: Low emphasis actions with text only
 * - ELEVATED_BUTTON: Actions that need visual separation
 * - FILLED_TONAL_BUTTON: Medium emphasis with tonal color
 *
 * @param config Button configuration containing type, text, and styling options
 * @param onClick Callback invoked when the button is clicked
 * @param modifier Optional modifier to be applied to the button
 */
@Composable
fun EveryButton(
    config: EveryButtonConfig,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Get size-specific properties
    val (containerHeight, contentPadding) = when (config.size) {
        ButtonSize.SMALL -> 32.dp to PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        ButtonSize.MEDIUM -> 40.dp to PaddingValues(horizontal = 16.dp, vertical = 8.dp) 
        ButtonSize.LARGE -> 48.dp to PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    }
    
    val buttonModifier = modifier
        .let { if (config.fullWidth) it.fillMaxWidth() else it }
        .heightIn(min = containerHeight)
    
    when (config.type) {
        ButtonType.FILLED_BUTTON -> {
            Button(
                onClick = onClick,
                enabled = config.enabled,
                modifier = buttonModifier,
                contentPadding = contentPadding
            ) {
                Text(config.text)
            }
        }
        ButtonType.OUTLINED_BUTTON -> {
            OutlinedButton(
                onClick = onClick,
                enabled = config.enabled,
                modifier = buttonModifier,
                contentPadding = contentPadding
            ) {
                Text(config.text)
            }
        }
        ButtonType.TEXT_BUTTON -> {
            TextButton(
                onClick = onClick,
                enabled = config.enabled,
                modifier = buttonModifier,
                contentPadding = contentPadding
            ) {
                Text(config.text)
            }
        }
        ButtonType.ELEVATED_BUTTON -> {
            ElevatedButton(
                onClick = onClick,
                enabled = config.enabled,
                modifier = buttonModifier,
                contentPadding = contentPadding
            ) {
                Text(config.text)
            }
        }
        ButtonType.FILLED_TONAL_BUTTON -> {
            FilledTonalButton(
                onClick = onClick,
                enabled = config.enabled,
                modifier = buttonModifier,
                contentPadding = contentPadding
            ) {
                Text(config.text)
            }
        }
    }
}

// Preview functions
@Preview
@Composable
fun FilledButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.FILLED_BUTTON,
                id = "filled-preview",
                text = "Filled Button"
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun OutlinedButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.OUTLINED_BUTTON,
                id = "outlined-preview",
                text = "Outlined Button"
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.TEXT_BUTTON,
                id = "text-preview",
                text = "Text Button"
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ElevatedButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.ELEVATED_BUTTON,
                id = "elevated-preview",
                text = "Elevated Button"
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun FilledTonalButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.FILLED_TONAL_BUTTON,
                id = "tonal-preview",
                text = "Filled Tonal"
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun DisabledButtonPreview() {
    MaterialTheme {
        EveryButton(
            config = EveryButtonConfig(
                type = ButtonType.FILLED_BUTTON,
                id = "disabled-preview",
                text = "Disabled Button",
                enabled = false
            ),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun FullWidthButtonPreview() {
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_BUTTON,
                    id = "fullwidth-preview",
                    text = "Full Width Button",
                    fullWidth = true
                ),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun ButtonSizesPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_BUTTON,
                    id = "small-preview",
                    text = "Small Button",
                    size = ButtonSize.SMALL
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_BUTTON,
                    id = "medium-preview",
                    text = "Medium Button",
                    size = ButtonSize.MEDIUM
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_BUTTON,
                    id = "large-preview",
                    text = "Large Button",
                    size = ButtonSize.LARGE
                ),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun AllButtonTypesPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_BUTTON,
                    id = "all-filled",
                    text = "Filled"
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.OUTLINED_BUTTON,
                    id = "all-outlined",
                    text = "Outlined"
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.TEXT_BUTTON,
                    id = "all-text",
                    text = "Text"
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.ELEVATED_BUTTON,
                    id = "all-elevated",
                    text = "Elevated"
                ),
                onClick = {}
            )
            
            EveryButton(
                config = EveryButtonConfig(
                    type = ButtonType.FILLED_TONAL_BUTTON,
                    id = "all-tonal",
                    text = "Filled Tonal"
                ),
                onClick = {}
            )
        }
    }
}