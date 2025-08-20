package io.everytech.everyapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Material 3 Expressive Design Tokens
 * Following the official M3 Expressive specifications for 2025
 */

// Color Tokens
object M3ExpressiveColors {
    // Light Theme Colors
    object Light {
        val primary = Color(0xFF6750A4)
        val onPrimary = Color(0xFFFFFFFF)
        val primaryContainer = Color(0xFFEADDFF)
        val onPrimaryContainer = Color(0xFF21005D)
        
        val secondary = Color(0xFF625B71)
        val onSecondary = Color(0xFFFFFFFF)
        val secondaryContainer = Color(0xFFE8DEF8)
        val onSecondaryContainer = Color(0xFF1D192B)
        
        val tertiary = Color(0xFF7D5260)
        val onTertiary = Color(0xFFFFFFFF)
        val tertiaryContainer = Color(0xFFFFD8E4)
        val onTertiaryContainer = Color(0xFF31111D)
        
        val surface = Color(0xFFFFFBFE)
        val onSurface = Color(0xFF1C1B1F)
        val surfaceVariant = Color(0xFFE7E0EC)
        val onSurfaceVariant = Color(0xFF49454F)
        val surfaceContainer = Color(0xFFF3EDF7)
        val surfaceContainerHigh = Color(0xFFECE6F0)
        val surfaceContainerHighest = Color(0xFFE6E0E9)
        
        val background = Color(0xFFFFFBFE)
        val onBackground = Color(0xFF1C1B1F)
        
        val error = Color(0xFFBA1A1A)
        val onError = Color(0xFFFFFFFF)
        val errorContainer = Color(0xFFFFDAD6)
        val onErrorContainer = Color(0xFF410002)
        
        val outline = Color(0xFF79747E)
        val outlineVariant = Color(0xFFCAC4D0)
        val scrim = Color(0xFF000000)
    }
    
    // Dark Theme Colors
    object Dark {
        val primary = Color(0xFFD0BCFF)
        val onPrimary = Color(0xFF381E72)
        val primaryContainer = Color(0xFF4F378B)
        val onPrimaryContainer = Color(0xFFEADDFF)
        
        val secondary = Color(0xFFCCC2DC)
        val onSecondary = Color(0xFF332D41)
        val secondaryContainer = Color(0xFF4A4458)
        val onSecondaryContainer = Color(0xFFE8DEF8)
        
        val tertiary = Color(0xFFEFB8C8)
        val onTertiary = Color(0xFF492532)
        val tertiaryContainer = Color(0xFF633B48)
        val onTertiaryContainer = Color(0xFFFFD8E4)
        
        val surface = Color(0xFF1C1B1F)
        val onSurface = Color(0xFFE6E1E5)
        val surfaceVariant = Color(0xFF49454F)
        val onSurfaceVariant = Color(0xFFCAC4D0)
        val surfaceContainer = Color(0xFF211F26)
        val surfaceContainerHigh = Color(0xFF2B2930)
        val surfaceContainerHighest = Color(0xFF36343B)
        
        val background = Color(0xFF1C1B1F)
        val onBackground = Color(0xFFE6E1E5)
        
        val error = Color(0xFFFFB4AB)
        val onError = Color(0xFF690005)
        val errorContainer = Color(0xFF93000A)
        val onErrorContainer = Color(0xFFFFDAD6)
        
        val outline = Color(0xFF938F99)
        val outlineVariant = Color(0xFF49454F)
        val scrim = Color(0xFF000000)
    }
}

// Spacing Tokens following M3 Expressive
object M3ExpressiveSpacing {
    // Base spacing unit (4dp)
    val unit = 4.dp
    
    // Spacing scale
    val none = 0.dp
    val extraSmall = 4.dp
    val small = 8.dp
    val medium = 16.dp
    val large = 24.dp
    val extraLarge = 32.dp
    val xxl = 48.dp
    val xxxl = 64.dp
    
    // Component specific spacing
    val cardPadding = medium
    val listItemPadding = medium
    val buttonPadding = large
    val fabPadding = medium
    val screenPadding = medium
    
    // Container spacing
    val containerGap = small
    val sectionGap = large
    val componentGap = medium
}

// Shape Tokens following M3 Expressive
object M3ExpressiveShapes {
    // M3 Expressive shape scale with enhanced rounding
    val none = 0.dp
    val extraSmall = 4.dp
    val small = 8.dp
    val medium = 12.dp
    val large = 16.dp
    val extraLarge = 28.dp
    val full = 999.dp // Full rounding for M3 Expressive
    
    // Component specific shapes
    val button = full // M3 Expressive buttons are fully rounded
    val card = medium
    val fab = large
    val chip = full
    val navigationBar = extraLarge
    val bottomSheet = extraLarge
}

// Elevation Tokens
object M3ExpressiveElevation {
    val level0 = 0.dp // Surface
    val level1 = 1.dp // Elevated surface
    val level2 = 3.dp // Navigation bar, cards
    val level3 = 6.dp // FAB, bottom sheet
    val level4 = 8.dp // Dialogs
    val level5 = 12.dp // Modal bottom sheets
}

// Motion Tokens for M3 Expressive
object M3ExpressiveMotion {
    // Duration tokens in milliseconds
    object Duration {
        const val short1 = 50
        const val short2 = 100
        const val short3 = 150
        const val short4 = 200
        const val medium1 = 250
        const val medium2 = 300
        const val medium3 = 350
        const val medium4 = 400
        const val long1 = 450
        const val long2 = 500
        const val long3 = 550
        const val long4 = 600
        const val extraLong1 = 700
        const val extraLong2 = 800
        const val extraLong3 = 900
        const val extraLong4 = 1000
    }
    
    // Easing curves for M3 Expressive
    object Easing {
        const val linear = "cubic-bezier(0.0, 0.0, 1.0, 1.0)"
        const val standard = "cubic-bezier(0.2, 0.0, 0, 1.0)"
        const val standardAccelerate = "cubic-bezier(0.3, 0, 1, 1)"
        const val standardDecelerate = "cubic-bezier(0, 0, 0, 1)"
        const val emphasized = "cubic-bezier(0.2, 0.0, 0, 1.0)"
        const val emphasizedAccelerate = "cubic-bezier(0.3, 0.0, 0.8, 0.15)"
        const val emphasizedDecelerate = "cubic-bezier(0.05, 0.7, 0.1, 1.0)"
    }
}

// Typography Tokens
object M3ExpressiveTypography {
    // Type scale following M3 Expressive specifications
    object Display {
        const val large = 57
        const val medium = 45
        const val small = 36
    }
    
    object Headline {
        const val large = 32
        const val medium = 28
        const val small = 24
    }
    
    object Title {
        const val large = 22
        const val medium = 16
        const val small = 14
    }
    
    object Body {
        const val large = 16
        const val medium = 14
        const val small = 12
    }
    
    object Label {
        const val large = 14
        const val medium = 12
        const val small = 11
    }
}

// Component Size Tokens
object M3ExpressiveSize {
    // Button sizes
    object Button {
        val small = 32.dp
        val medium = 40.dp
        val large = 56.dp
    }
    
    // FAB sizes
    object FAB {
        val small = 40.dp
        val regular = 56.dp
        val large = 96.dp
        val extended = 56.dp // height for extended FAB
    }
    
    // Navigation bar
    object Navigation {
        val height = 80.dp
        val itemSize = 32.dp
    }
    
    // List items
    object ListItem {
        val oneLineHeight = 56.dp
        val twoLineHeight = 72.dp
        val threeLineHeight = 88.dp
    }
}