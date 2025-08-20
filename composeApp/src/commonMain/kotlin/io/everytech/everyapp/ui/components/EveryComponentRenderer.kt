package io.everytech.everyapp.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.everytech.everyapp.data.*
import io.everytech.everyapp.ui.theme.*

/**
 * Material 3 Expressive Component Renderer
 * Follows M3 Expressive design tokens, spacing, and motion
 */

@Composable
fun EveryAppRenderer(
    app: EveryAppData,
    modifier: Modifier = Modifier
) {
    val currentScreen = remember { mutableStateOf(app.screens.firstOrNull()) }
    
    currentScreen.value?.let { screen ->
        EveryScreenRenderer(
            screen = screen,
            theme = app.theme,
            navigation = app.navigation,
            modifier = modifier
        )
    }
}

@Composable
fun EveryScreenRenderer(
    screen: EveryScreenData,
    theme: EveryThemeData,
    navigation: EveryNavigationData?,
    modifier: Modifier = Modifier
) {
    val backgroundColor = screen.backgroundColor?.let { Color(it.removePrefix("#").toLong(16) or 0xFF000000) }
        ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.background else M3ExpressiveColors.Light.background
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Screen content
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = screen.padding.horizontal.dp,
                    vertical = screen.padding.vertical.dp
                ),
            verticalArrangement = Arrangement.spacedBy(M3ExpressiveSpacing.componentGap)
        ) {
            items(screen.components) { component ->
                EveryComponentRenderer(
                    component = component,
                    theme = theme
                )
            }
        }
        
        // Bottom navigation if present
        navigation?.let { nav ->
            if (nav.type == "bottom") {
                EveryNavigationRenderer(
                    navigation = nav,
                    theme = theme
                )
            }
        }
    }
}

@Composable
fun EveryComponentRenderer(
    component: EveryComponentData,
    theme: EveryThemeData
) {
    Column(
        modifier = Modifier.padding(
            top = component.spacing.top.dp,
            bottom = component.spacing.bottom.dp,
            start = component.spacing.start.dp,
            end = component.spacing.end.dp
        )
    ) {
        when (component) {
            is EveryCardData -> EveryCardRenderer(component, theme)
            is EveryButtonData -> EveryButtonRenderer(component, theme)
            is EveryTextData -> EveryTextRenderer(component, theme)
            is EveryListData -> EveryListRenderer(component, theme)
            is EveryGridData -> EveryGridRenderer(component, theme)
            is EveryFABData -> EveryFABRenderer(component, theme)
            is EveryNavigationData -> EveryNavigationRenderer(component, theme)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EveryCardRenderer(
    card: EveryCardData,
    theme: EveryThemeData
) {
    val backgroundColor = card.style.backgroundColor?.let { 
        Color(it.removePrefix("#").toLong(16) or 0xFF000000) 
    } ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.surfaceContainer else M3ExpressiveColors.Light.surfaceContainer
    
    val elevation = when (card.style.elevation) {
        0 -> M3ExpressiveElevation.level0
        1 -> M3ExpressiveElevation.level1
        2 -> M3ExpressiveElevation.level2
        3 -> M3ExpressiveElevation.level3
        4 -> M3ExpressiveElevation.level4
        else -> M3ExpressiveElevation.level5
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(), // M3 Expressive motion
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        shape = RoundedCornerShape(card.style.cornerRadius.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = card.style.contentPadding.horizontal.dp,
                vertical = card.style.contentPadding.vertical.dp
            ),
            verticalArrangement = Arrangement.spacedBy(M3ExpressiveSpacing.small)
        ) {
            // Card title
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium,
                color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onSurface else M3ExpressiveColors.Light.onSurface
            )
            
            // Card subtitle
            card.subtitle?.let { subtitle ->
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onSurfaceVariant else M3ExpressiveColors.Light.onSurfaceVariant
                )
            }
            
            // Card content
            card.content?.let { content ->
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onSurfaceVariant else M3ExpressiveColors.Light.onSurfaceVariant
                )
            }
            
            // Card actions
            if (card.actions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(M3ExpressiveSpacing.small))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(M3ExpressiveSpacing.small)
                ) {
                    card.actions.forEach { action ->
                        when (action.type) {
                            "primary" -> {
                                Button(
                                    onClick = { /* Handle action */ },
                                    shape = RoundedCornerShape(M3ExpressiveShapes.button),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(action.text)
                                }
                            }
                            "secondary" -> {
                                OutlinedButton(
                                    onClick = { /* Handle action */ },
                                    shape = RoundedCornerShape(M3ExpressiveShapes.button),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(action.text)
                                }
                            }
                            else -> {
                                TextButton(
                                    onClick = { /* Handle action */ },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(action.text)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EveryButtonRenderer(
    button: EveryButtonData,
    theme: EveryThemeData
) {
    val shape = RoundedCornerShape(button.style.cornerRadius.dp)
    val modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = button.style.contentPadding.horizontal.dp,
            vertical = button.style.contentPadding.vertical.dp
        )
    
    when (button.style.variant) {
        "filled" -> {
            Button(
                onClick = { /* Handle action */ },
                modifier = modifier,
                shape = shape,
                enabled = button.style.enabled
            ) {
                ButtonContent(button)
            }
        }
        "outlined" -> {
            OutlinedButton(
                onClick = { /* Handle action */ },
                modifier = modifier,
                shape = shape,
                enabled = button.style.enabled
            ) {
                ButtonContent(button)
            }
        }
        "text" -> {
            TextButton(
                onClick = { /* Handle action */ },
                modifier = modifier,
                shape = shape,
                enabled = button.style.enabled
            ) {
                ButtonContent(button)
            }
        }
        "elevated" -> {
            ElevatedButton(
                onClick = { /* Handle action */ },
                modifier = modifier,
                shape = shape,
                enabled = button.style.enabled
            ) {
                ButtonContent(button)
            }
        }
        else -> { // "tonal"
            FilledTonalButton(
                onClick = { /* Handle action */ },
                modifier = modifier,
                shape = shape,
                enabled = button.style.enabled
            ) {
                ButtonContent(button)
            }
        }
    }
}

@Composable
private fun ButtonContent(button: EveryButtonData) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(M3ExpressiveSpacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        button.icon?.let { icon ->
            Text(
                text = icon,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Text(
            text = button.text,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun EveryTextRenderer(
    text: EveryTextData,
    theme: EveryThemeData
) {
    val textColor = text.style.color?.let { 
        Color(it.removePrefix("#").toLong(16) or 0xFF000000) 
    } ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onBackground else M3ExpressiveColors.Light.onBackground
    
    val textAlign = when (text.alignment) {
        "center" -> TextAlign.Center
        "end" -> TextAlign.End
        else -> TextAlign.Start
    }
    
    val textStyle = when (text.style.variant) {
        "displayLarge" -> MaterialTheme.typography.displayLarge
        "headlineLarge" -> MaterialTheme.typography.headlineLarge
        "titleLarge" -> MaterialTheme.typography.titleLarge
        "bodyLarge" -> MaterialTheme.typography.bodyLarge
        "labelLarge" -> MaterialTheme.typography.labelLarge
        else -> MaterialTheme.typography.bodyLarge
    }
    
    val fontWeight = when (text.style.weight) {
        "medium" -> FontWeight.Medium
        "bold" -> FontWeight.Bold
        else -> FontWeight.Normal
    }
    
    Text(
        text = text.text,
        style = textStyle,
        color = textColor,
        textAlign = textAlign,
        fontWeight = fontWeight,
        fontSize = text.style.size.sp,
        lineHeight = text.style.lineHeight.sp,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EveryListRenderer(
    list: EveryListData,
    theme: EveryThemeData
) {
    val backgroundColor = list.style.backgroundColor?.let { 
        Color(it.removePrefix("#").toLong(16) or 0xFF000000) 
    } ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.surfaceContainer else M3ExpressiveColors.Light.surfaceContainer
    
    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(list.style.cornerRadius.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = M3ExpressiveElevation.level1)
    ) {
        Column {
            list.items.forEachIndexed { index, item ->
                ListItem(
                    headlineContent = { 
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium
                        )
                    },
                    supportingContent = item.subtitle?.let { { 
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onSurfaceVariant else M3ExpressiveColors.Light.onSurfaceVariant
                        )
                    }},
                    leadingContent = item.icon?.let { { 
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }},
                    trailingContent = item.trailing?.let { trailing ->
                        {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(M3ExpressiveSpacing.small),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                item.badgeCount?.let { count ->
                                    if (count > 0) {
                                        Badge {
                                            Text("$count")
                                        }
                                    }
                                }
                                Text(
                                    text = trailing,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onSurfaceVariant else M3ExpressiveColors.Light.onSurfaceVariant
                                )
                            }
                        }
                    },
                    modifier = Modifier.clickable { /* Handle item click */ }
                )
                
                if (list.style.dividers && index < list.items.lastIndex) {
                    HorizontalDivider(
                        color = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.outlineVariant else M3ExpressiveColors.Light.outlineVariant
                    )
                }
            }
        }
    }
}

@Composable
fun EveryGridRenderer(
    grid: EveryGridData,
    theme: EveryThemeData
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(grid.columns),
        verticalArrangement = Arrangement.spacedBy(grid.style.itemSpacing.dp),
        horizontalArrangement = Arrangement.spacedBy(grid.style.itemSpacing.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(grid.items) { item ->
            Box(
                modifier = Modifier.aspectRatio(
                    when (grid.style.aspectRatio) {
                        "16:9" -> 16f / 9f
                        "4:3" -> 4f / 3f
                        else -> 1f
                    }
                )
            ) {
                EveryComponentRenderer(
                    component = item,
                    theme = theme
                )
            }
        }
    }
}

@Composable
fun EveryFABRenderer(
    fab: EveryFABData,
    theme: EveryThemeData
) {
    val backgroundColor = fab.style.backgroundColor?.let { 
        Color(it.removePrefix("#").toLong(16) or 0xFF000000) 
    } ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.primaryContainer else M3ExpressiveColors.Light.primaryContainer
    
    val contentColor = fab.style.contentColor?.let { 
        Color(it.removePrefix("#").toLong(16) or 0xFF000000) 
    } ?: if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.onPrimaryContainer else M3ExpressiveColors.Light.onPrimaryContainer
    
    when (fab.style.size) {
        "small" -> {
            SmallFloatingActionButton(
                onClick = { /* Handle click */ },
                containerColor = backgroundColor,
                contentColor = contentColor,
                shape = RoundedCornerShape(fab.style.cornerRadius.dp)
            ) {
                Text(fab.icon)
            }
        }
        "large" -> {
            LargeFloatingActionButton(
                onClick = { /* Handle click */ },
                containerColor = backgroundColor,
                contentColor = contentColor,
                shape = RoundedCornerShape(fab.style.cornerRadius.dp)
            ) {
                Text(fab.icon, style = MaterialTheme.typography.titleLarge)
            }
        }
        "extended" -> {
            ExtendedFloatingActionButton(
                onClick = { /* Handle click */ },
                containerColor = backgroundColor,
                contentColor = contentColor,
                shape = RoundedCornerShape(fab.style.cornerRadius.dp),
                icon = { Text(fab.icon) },
                text = { fab.text?.let { Text(it) } }
            )
        }
        else -> { // "regular"
            FloatingActionButton(
                onClick = { /* Handle click */ },
                containerColor = backgroundColor,
                contentColor = contentColor,
                shape = RoundedCornerShape(fab.style.cornerRadius.dp)
            ) {
                Text(fab.icon)
            }
        }
    }
}

@Composable
fun EveryNavigationRenderer(
    navigation: EveryNavigationData,
    theme: EveryThemeData
) {
    NavigationBar(
        containerColor = if (theme.colorScheme.isDark) M3ExpressiveColors.Dark.surfaceContainer else M3ExpressiveColors.Light.surfaceContainer,
        tonalElevation = navigation.style.elevation.dp
    ) {
        navigation.items.forEach { item ->
            NavigationBarItem(
                icon = { 
                    Box {
                        Text(
                            text = if (item.selected) item.selectedIcon ?: item.icon else item.icon,
                            style = MaterialTheme.typography.titleMedium
                        )
                        item.badgeCount?.let { count ->
                            if (count > 0) {
                                Badge(
                                    modifier = Modifier.align(Alignment.TopEnd)
                                ) {
                                    Text("$count")
                                }
                            }
                        }
                    }
                },
                label = { 
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelMedium
                    ) 
                },
                selected = item.selected,
                onClick = { /* Handle navigation */ }
            )
        }
    }
}