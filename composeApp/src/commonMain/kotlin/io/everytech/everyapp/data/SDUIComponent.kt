package io.everytech.everyapp.data

import kotlinx.serialization.Serializable

@Serializable
data class SDUIScreen(
    val id: String,
    val components: List<SDUIComponent>,
    val motionScheme: String = "expressive",
    val backgroundColor: String? = null
)

@Serializable
sealed class SDUIComponent {
    abstract val id: String
    abstract val type: String
}

@Serializable
data class CardComponent(
    override val id: String,
    override val type: String = "card",
    val title: String,
    val subtitle: String? = null,
    val content: String? = null,
    val imageUrl: String? = null,
    val actions: List<ActionComponent> = emptyList(),
    val style: String = "elevated",
    val cornerRadius: Int = 16
) : SDUIComponent()

@Serializable
data class ButtonComponent(
    override val id: String,
    override val type: String = "button",
    val text: String,
    val style: String = "filled", // filled, outlined, text
    val color: String? = null,
    val action: String? = null
) : SDUIComponent()

@Serializable
data class TextComponent(
    override val id: String,
    override val type: String = "text",
    val text: String,
    val style: String = "body", // headline, title, body, caption
    val alignment: String = "start",
    val color: String? = null
) : SDUIComponent()

@Serializable
data class ListComponent(
    override val id: String,
    override val type: String = "list",
    val items: List<ListItemComponent>,
    val style: String = "default"
) : SDUIComponent()

@Serializable
data class ListItemComponent(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val iconName: String? = null,
    val trailing: String? = null,
    val action: String? = null
)

@Serializable
data class ActionComponent(
    val id: String,
    val text: String,
    val type: String = "button", // button, icon
    val action: String? = null
)

@Serializable
data class ColumnComponent(
    override val id: String,
    override val type: String = "column",
    val components: List<SDUIComponent>,
    val spacing: Int = 16,
    val padding: Int = 16,
    val alignment: String = "center"
) : SDUIComponent()

@Serializable
data class RowComponent(
    override val id: String,
    override val type: String = "row", 
    val components: List<SDUIComponent>,
    val spacing: Int = 8,
    val arrangement: String = "start"
) : SDUIComponent()

@Serializable
data class ImageComponent(
    override val id: String,
    override val type: String = "image",
    val url: String? = null,
    val placeholder: String = "📷",
    val aspectRatio: String = "1:1", // "16:9", "4:3", "1:1"
    val cornerRadius: Int = 8,
    val contentScale: String = "crop" // crop, fit, fillWidth
) : SDUIComponent()

@Serializable
data class ChartComponent(
    override val id: String,
    override val type: String = "chart",
    val chartType: String = "line", // line, bar, pie, donut
    val data: List<ChartDataPoint>,
    val title: String? = null,
    val height: Int = 200,
    val colors: List<String> = listOf("#6750A4", "#7D5260", "#625B71")
) : SDUIComponent()

@Serializable
data class ChartDataPoint(
    val label: String,
    val value: Float,
    val color: String? = null
)

@Serializable
data class ProgressComponent(
    override val id: String,
    override val type: String = "progress",
    val value: Float, // 0.0 to 1.0
    val label: String? = null,
    val showPercentage: Boolean = true,
    val style: String = "linear", // linear, circular
    val color: String? = null
) : SDUIComponent()

@Serializable
data class ChipComponent(
    override val id: String,
    override val type: String = "chip",
    val text: String,
    val style: String = "assist", // assist, filter, input, suggestion
    val selected: Boolean = false,
    val icon: String? = null,
    val action: String? = null
) : SDUIComponent()

@Serializable
data class NavigationComponent(
    override val id: String,
    override val type: String = "navigation",
    val style: String = "bottom", // bottom, top, drawer
    val items: List<NavigationItem>
) : SDUIComponent()

@Serializable
data class NavigationItem(
    val id: String,
    val label: String,
    val icon: String,
    val selected: Boolean = false,
    val badgeCount: Int? = null
)

@Serializable
data class FABComponent(
    override val id: String,
    override val type: String = "fab",
    val text: String? = null,
    val icon: String = "➕",
    val style: String = "regular", // regular, extended, small, large
    val action: String? = null
) : SDUIComponent()

@Serializable
data class GridComponent(
    override val id: String,
    override val type: String = "grid",
    val components: List<SDUIComponent>,
    val columns: Int = 2,
    val spacing: Int = 8,
    val aspectRatio: String = "1:1"
) : SDUIComponent()