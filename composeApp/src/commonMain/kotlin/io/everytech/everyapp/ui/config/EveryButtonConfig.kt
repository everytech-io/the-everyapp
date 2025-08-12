package io.everytech.everyapp.ui.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class EveryButtonConfig(
    val text: String = "",
    val enabled: Boolean = true,
    val cornerRadius: Dp = 8.dp,
    val contentPadding: Dp = 12.dp,
    val borderWidth: Dp = 1.dp,
    val textStyle: TextStyle = TextStyle(fontSize = 14.sp),
    val backgroundColor: Color? = null,
    val textColor: Color? = null,
    val borderColor: Color? = null,
    val disabledBackgroundColor: Color? = null,
    val disabledTextColor: Color? = null,
    val hoverBackgroundColor: Color? = null,
    val pressedBackgroundColor: Color? = null
)