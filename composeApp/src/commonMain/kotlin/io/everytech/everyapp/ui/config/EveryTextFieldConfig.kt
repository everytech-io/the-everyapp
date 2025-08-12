package io.everytech.everyapp.ui.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class EveryTextFieldConfig(
    val placeholder: String = "",
    val value: String = "",
    val minHeight: Dp = 120.dp,
    val maxHeight: Dp = 400.dp,
    val singleLine: Boolean = false,
    val maxLines: Int = Int.MAX_VALUE,
    val enabled: Boolean = true,
    val readOnly: Boolean = false,
    val textStyle: TextStyle = TextStyle(fontSize = 16.sp),
    val placeholderStyle: TextStyle = TextStyle(fontSize = 16.sp),
    val cornerRadius: Dp = 12.dp,
    val contentPadding: Dp = 16.dp,
    val borderWidth: Dp = 1.dp,
    val backgroundColor: Color? = null,
    val borderColor: Color? = null,
    val textColor: Color? = null,
    val placeholderColor: Color? = null,
    val cursorColor: Color? = null,
    val focusedBorderColor: Color? = null
)