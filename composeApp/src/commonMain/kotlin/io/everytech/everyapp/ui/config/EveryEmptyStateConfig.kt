package io.everytech.everyapp.ui.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class EveryEmptyStateConfig(
    val title: String = "Welcome to EveryApp!",
    val subtitle: String = "",
    val textFieldConfig: EveryTextFieldConfig = EveryTextFieldConfig(
        placeholder = "Describe the app you want to build...",
        minHeight = 160.dp,
        maxHeight = 400.dp,
        maxLines = 10
    ),
    val quickActions: List<QuickActionConfig> = emptyList(),
    val showIcon: Boolean = true,
    val iconEmoji: String = "✨",
    val iconSize: Dp = 48.dp,
    val titleStyle: TextStyle = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    ),
    val subtitleStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    ),
    val spacing: Dp = 24.dp,
    val backgroundColor: Color? = null,
    val titleColor: Color? = null,
    val subtitleColor: Color? = null
)

data class QuickActionConfig(
    val label: String,
    val icon: String? = null,
    val onClick: () -> Unit = {}
)