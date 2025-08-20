package io.everytech.everyapp.data

import kotlinx.serialization.Serializable

/**
 * Material 3 Expressive Component Data Structures
 * Following M3 Expressive design tokens, spacing, and color system
 */

@Serializable
data class EveryAppData(
    val id: String,
    val title: String,
    val screens: List<EveryScreenData>,
    val navigation: EveryNavigationData? = null,
    val theme: EveryThemeData = EveryThemeData()
)

@Serializable
data class EveryScreenData(
    val id: String,
    val title: String,
    val components: List<EveryComponentData>,
    val backgroundColor: String? = null,
    val padding: EverySpacingData = EverySpacingData(),
    val motionScheme: String = "expressive" // "standard" | "expressive"
)

@Serializable
sealed class EveryComponentData {
    abstract val id: String
    abstract val spacing: EverySpacingData
}

@Serializable
data class EveryCardData(
    override val id: String,
    val title: String,
    val subtitle: String? = null,
    val content: String? = null,
    val imageUrl: String? = null,
    val actions: List<EveryActionData> = emptyList(),
    val style: EveryCardStyle = EveryCardStyle(),
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryButtonData(
    override val id: String,
    val text: String,
    val icon: String? = null,
    val style: EveryButtonStyle = EveryButtonStyle(),
    val action: String? = null,
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryTextData(
    override val id: String,
    val text: String,
    val style: EveryTextStyle = EveryTextStyle(),
    val alignment: String = "start", // "start" | "center" | "end"
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryListData(
    override val id: String,
    val items: List<EveryListItemData>,
    val style: EveryListStyle = EveryListStyle(),
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryGridData(
    override val id: String,
    val items: List<EveryComponentData>,
    val columns: Int = 2,
    val style: EveryGridStyle = EveryGridStyle(),
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryNavigationData(
    override val id: String,
    val type: String = "bottom", // "bottom" | "top" | "rail" | "drawer"
    val items: List<EveryNavigationItemData>,
    val style: EveryNavigationStyle = EveryNavigationStyle(),
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

@Serializable
data class EveryFABData(
    override val id: String,
    val icon: String,
    val text: String? = null,
    val style: EveryFABStyle = EveryFABStyle(),
    val action: String? = null,
    override val spacing: EverySpacingData = EverySpacingData()
) : EveryComponentData()

// Supporting Data Classes

@Serializable
data class EveryActionData(
    val id: String,
    val text: String,
    val icon: String? = null,
    val type: String = "primary", // "primary" | "secondary" | "tertiary"
    val action: String? = null
)

@Serializable
data class EveryListItemData(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val icon: String? = null,
    val trailing: String? = null,
    val badgeCount: Int? = null,
    val action: String? = null
)

@Serializable
data class EveryNavigationItemData(
    val id: String,
    val label: String,
    val icon: String,
    val selectedIcon: String? = null,
    val selected: Boolean = false,
    val badgeCount: Int? = null,
    val action: String? = null
)

// Style Data Classes following M3 Expressive

@Serializable
data class EveryThemeData(
    val colorScheme: EveryColorSchemeData = EveryColorSchemeData(),
    val typography: EveryTypographyData = EveryTypographyData(),
    val shapes: EveryShapeData = EveryShapeData(),
    val motion: EveryMotionData = EveryMotionData()
)

@Serializable
data class EveryColorSchemeData(
    val primary: String = "#6750A4",
    val onPrimary: String = "#FFFFFF",
    val primaryContainer: String = "#EADDFF",
    val onPrimaryContainer: String = "#21005D",
    val secondary: String = "#625B71",
    val onSecondary: String = "#FFFFFF",
    val secondaryContainer: String = "#E8DEF8",
    val onSecondaryContainer: String = "#1D192B",
    val tertiary: String = "#7D5260",
    val onTertiary: String = "#FFFFFF",
    val tertiaryContainer: String = "#FFD8E4",
    val onTertiaryContainer: String = "#31111D",
    val surface: String = "#FFFBFE",
    val onSurface: String = "#1C1B1F",
    val surfaceVariant: String = "#E7E0EC",
    val onSurfaceVariant: String = "#49454F",
    val background: String = "#FFFBFE",
    val onBackground: String = "#1C1B1F",
    val isDark: Boolean = false
)

@Serializable
data class EverySpacingData(
    val top: Int = 0,
    val bottom: Int = 0,
    val start: Int = 0,
    val end: Int = 0,
    val horizontal: Int = 16,
    val vertical: Int = 16,
    val inner: Int = 8 // spacing between child elements
)

@Serializable
data class EveryCardStyle(
    val elevation: Int = 1, // 0-5 elevation levels
    val cornerRadius: Int = 12, // M3 Expressive rounded corners
    val backgroundColor: String? = null,
    val strokeColor: String? = null,
    val strokeWidth: Int = 0,
    val contentPadding: EverySpacingData = EverySpacingData(horizontal = 16, vertical = 16)
)

@Serializable
data class EveryButtonStyle(
    val variant: String = "filled", // "filled" | "outlined" | "text" | "elevated" | "tonal"
    val size: String = "medium", // "small" | "medium" | "large"
    val cornerRadius: Int = 20, // M3 Expressive full rounding for buttons
    val backgroundColor: String? = null,
    val textColor: String? = null,
    val strokeColor: String? = null,
    val strokeWidth: Int = 1,
    val contentPadding: EverySpacingData = EverySpacingData(horizontal = 24, vertical = 10),
    val enabled: Boolean = true
)

@Serializable
data class EveryTextStyle(
    val variant: String = "bodyLarge", // "displayLarge" | "headlineLarge" | "titleLarge" | "bodyLarge" | "labelLarge"
    val color: String? = null,
    val weight: String = "normal", // "normal" | "medium" | "bold"
    val size: Int = 16,
    val lineHeight: Int = 24
)

@Serializable
data class EveryListStyle(
    val dividers: Boolean = true,
    val backgroundColor: String? = null,
    val itemPadding: EverySpacingData = EverySpacingData(horizontal = 16, vertical = 8),
    val cornerRadius: Int = 12
)

@Serializable
data class EveryGridStyle(
    val aspectRatio: String = "1:1", // "1:1" | "16:9" | "4:3"
    val itemSpacing: Int = 8,
    val backgroundColor: String? = null,
    val cornerRadius: Int = 16
)

@Serializable
data class EveryNavigationStyle(
    val backgroundColor: String? = null,
    val selectedColor: String? = null,
    val unselectedColor: String? = null,
    val indicatorColor: String? = null,
    val elevation: Int = 3,
    val height: Int = 80
)

@Serializable
data class EveryFABStyle(
    val size: String = "regular", // "small" | "regular" | "large" | "extended"
    val backgroundColor: String? = null,
    val contentColor: String? = null,
    val elevation: Int = 6,
    val cornerRadius: Int = 16 // M3 Expressive FAB rounding
)

@Serializable
data class EveryTypographyData(
    val displayLarge: EveryTextStyle = EveryTextStyle(variant = "displayLarge", size = 57, lineHeight = 64, weight = "normal"),
    val headlineLarge: EveryTextStyle = EveryTextStyle(variant = "headlineLarge", size = 32, lineHeight = 40, weight = "normal"),
    val titleLarge: EveryTextStyle = EveryTextStyle(variant = "titleLarge", size = 22, lineHeight = 28, weight = "normal"),
    val bodyLarge: EveryTextStyle = EveryTextStyle(variant = "bodyLarge", size = 16, lineHeight = 24, weight = "normal"),
    val labelLarge: EveryTextStyle = EveryTextStyle(variant = "labelLarge", size = 14, lineHeight = 20, weight = "medium")
)

@Serializable
data class EveryShapeData(
    val extraSmall: Int = 4,
    val small: Int = 8,
    val medium: Int = 12,
    val large: Int = 16,
    val extraLarge: Int = 28,
    val full: String = "50%" // M3 Expressive full rounding
)

@Serializable
data class EveryMotionData(
    val scheme: String = "expressive", // "standard" | "expressive"
    val duration: EveryDurationData = EveryDurationData(),
    val easing: EveryEasingData = EveryEasingData()
)

@Serializable
data class EveryDurationData(
    val short1: Int = 50,
    val short2: Int = 100,
    val short3: Int = 150,
    val short4: Int = 200,
    val medium1: Int = 250,
    val medium2: Int = 300,
    val medium3: Int = 350,
    val medium4: Int = 400,
    val long1: Int = 450,
    val long2: Int = 500,
    val long3: Int = 550,
    val long4: Int = 600,
    val extraLong1: Int = 700,
    val extraLong2: Int = 800,
    val extraLong3: Int = 900,
    val extraLong4: Int = 1000
)

@Serializable
data class EveryEasingData(
    val linear: String = "cubic-bezier(0.0, 0.0, 1.0, 1.0)",
    val standard: String = "cubic-bezier(0.2, 0.0, 0, 1.0)",
    val standardAccelerate: String = "cubic-bezier(0.3, 0, 1, 1)",
    val standardDecelerate: String = "cubic-bezier(0, 0, 0, 1)",
    val emphasized: String = "cubic-bezier(0.2, 0.0, 0, 1.0)",
    val emphasizedAccelerate: String = "cubic-bezier(0.3, 0.0, 0.8, 0.15)",
    val emphasizedDecelerate: String = "cubic-bezier(0.05, 0.7, 0.1, 1.0)"
)