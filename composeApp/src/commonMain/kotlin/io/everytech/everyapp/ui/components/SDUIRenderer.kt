package io.everytech.everyapp.ui.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.everytech.everyapp.data.*

@Composable
fun SDUIRenderer(
    screen: SDUIScreen,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(screen.components) { component ->
            RenderComponent(component = component)
        }
    }
}

@Composable
fun RenderComponent(component: SDUIComponent) {
    when (component) {
        is CardComponent -> RenderCard(component)
        is ButtonComponent -> RenderButton(component)
        is TextComponent -> RenderText(component)
        is ListComponent -> RenderList(component)
        is ColumnComponent -> RenderColumn(component)
        is RowComponent -> RenderRow(component)
        is ImageComponent -> RenderImage(component)
        is ChartComponent -> RenderChart(component)
        is ProgressComponent -> RenderProgress(component)
        is ChipComponent -> RenderChip(component)
        is NavigationComponent -> RenderNavigation(component)
        is FABComponent -> RenderFAB(component)
        is GridComponent -> RenderGrid(component)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderCard(card: CardComponent) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = if (card.style == "elevated") 6.dp else 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            if (card.subtitle != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = card.subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            if (card.content != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = card.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            
            if (card.actions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    card.actions.forEach { action ->
                        when (action.type) {
                            "button" -> {
                                Button(
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
fun RenderButton(button: ButtonComponent) {
    when (button.style) {
        "filled" -> {
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(button.text)
            }
        }
        "outlined" -> {
            OutlinedButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(button.text)
            }
        }
        "text" -> {
            TextButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(button.text)
            }
        }
    }
}

@Composable
fun RenderText(text: TextComponent) {
    val textAlign = when (text.alignment) {
        "center" -> TextAlign.Center
        "end" -> TextAlign.End
        else -> TextAlign.Start
    }
    
    when (text.style) {
        "headline" -> {
            Text(
                text = text.text,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )
        }
        "title" -> {
            Text(
                text = text.text,
                style = MaterialTheme.typography.titleLarge,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )
        }
        "caption" -> {
            Text(
                text = text.text,
                style = MaterialTheme.typography.labelMedium,
                textAlign = textAlign,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            )
        }
        else -> { // body
            Text(
                text = text.text,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderList(list: ListComponent) {
    Card {
        Column {
            list.items.forEachIndexed { index, item ->
                ListItem(
                    headlineContent = { Text(item.title) },
                    supportingContent = if (item.subtitle != null) {
                        { Text(item.subtitle) }
                    } else null,
                    trailingContent = if (item.trailing != null) {
                        { Text(item.trailing) }
                    } else null
                )
                if (index < list.items.lastIndex) {
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun RenderColumn(column: ColumnComponent) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(column.padding.dp),
        verticalArrangement = Arrangement.spacedBy(column.spacing.dp),
        horizontalAlignment = when (column.alignment) {
            "start" -> Alignment.Start
            "end" -> Alignment.End
            else -> Alignment.CenterHorizontally
        }
    ) {
        column.components.forEach { component ->
            RenderComponent(component)
        }
    }
}

@Composable
fun RenderRow(row: RowComponent) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = when (row.arrangement) {
            "spaceEvenly" -> Arrangement.SpaceEvenly
            "spaceBetween" -> Arrangement.SpaceBetween
            "spaceAround" -> Arrangement.SpaceAround
            "center" -> Arrangement.Center
            "end" -> Arrangement.End
            else -> Arrangement.spacedBy(row.spacing.dp)
        }
    ) {
        row.components.forEach { component ->
            Box(modifier = Modifier.weight(1f)) {
                RenderComponent(component)
            }
        }
    }
}

@Composable
fun RenderImage(image: ImageComponent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(
                when (image.aspectRatio) {
                    "16:9" -> 16f / 9f
                    "4:3" -> 4f / 3f
                    else -> 1f
                }
            ),
        shape = RoundedCornerShape(image.cornerRadius.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = image.placeholder,
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}

@Composable
fun RenderChart(chart: ChartComponent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(chart.height.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (chart.title != null) {
                Text(
                    text = chart.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            
            // Placeholder chart visualization
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "📊",
                        style = MaterialTheme.typography.displayMedium
                    )
                    Text(
                        text = "${chart.chartType.uppercase()} CHART",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun RenderProgress(progress: ProgressComponent) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (progress.label != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = progress.label,
                    style = MaterialTheme.typography.bodyMedium
                )
                if (progress.showPercentage) {
                    Text(
                        text = "${(progress.value * 100).toInt()}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        when (progress.style) {
            "circular" -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        progress = { progress.value },
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
            else -> {
                LinearProgressIndicator(
                    progress = { progress.value },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun RenderChip(chip: ChipComponent) {
    when (chip.style) {
        "filter" -> {
            FilterChip(
                onClick = { /* Handle click */ },
                label = { Text(chip.text) },
                selected = chip.selected
            )
        }
        "input" -> {
            InputChip(
                onClick = { /* Handle click */ },
                label = { Text(chip.text) },
                selected = chip.selected
            )
        }
        "suggestion" -> {
            SuggestionChip(
                onClick = { /* Handle click */ },
                label = { Text(chip.text) }
            )
        }
        else -> {
            AssistChip(
                onClick = { /* Handle click */ },
                label = { Text(chip.text) }
            )
        }
    }
}

@Composable
fun RenderNavigation(navigation: NavigationComponent) {
    when (navigation.style) {
        "bottom" -> {
            NavigationBar {
                navigation.items.forEach { item ->
                    NavigationBarItem(
                        icon = { 
                            Row {
                                Text(item.icon)
                                if (item.badgeCount != null && item.badgeCount > 0) {
                                    Badge {
                                        Text("${item.badgeCount}")
                                    }
                                }
                            }
                        },
                        label = { Text(item.label) },
                        selected = item.selected,
                        onClick = { /* Handle navigation */ }
                    )
                }
            }
        }
        else -> {
            // Default to bottom navigation
            RenderNavigation(navigation.copy(style = "bottom"))
        }
    }
}

@Composable
fun RenderFAB(fab: FABComponent) {
    when (fab.style) {
        "extended" -> {
            ExtendedFloatingActionButton(
                onClick = { /* Handle click */ },
                icon = { Text(fab.icon) },
                text = { fab.text?.let { Text(it) } }
            )
        }
        "small" -> {
            SmallFloatingActionButton(
                onClick = { /* Handle click */ }
            ) {
                Text(fab.icon)
            }
        }
        "large" -> {
            LargeFloatingActionButton(
                onClick = { /* Handle click */ }
            ) {
                Text(fab.icon)
            }
        }
        else -> {
            FloatingActionButton(
                onClick = { /* Handle click */ }
            ) {
                Text(fab.icon)
            }
        }
    }
}

@Composable
fun RenderGrid(grid: GridComponent) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(grid.columns),
        verticalArrangement = Arrangement.spacedBy(grid.spacing.dp),
        horizontalArrangement = Arrangement.spacedBy(grid.spacing.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(grid.components) { component ->
            Box(
                modifier = Modifier.aspectRatio(
                    when (grid.aspectRatio) {
                        "16:9" -> 16f / 9f
                        "4:3" -> 4f / 3f
                        else -> 1f
                    }
                )
            ) {
                RenderComponent(component)
            }
        }
    }
}