package io.everytech.everyapp.ui.config

/**
 * Enum representing different Material 3 button types.
 */
enum class ButtonType {
    /** High emphasis actions with filled background */
    FILLED_BUTTON,
    /** Medium emphasis actions with outlined style */
    OUTLINED_BUTTON,
    /** Low emphasis actions with text only */
    TEXT_BUTTON,
    /** Actions that need visual separation */
    ELEVATED_BUTTON,
    /** Medium emphasis with tonal color */
    FILLED_TONAL_BUTTON
}

/**
 * Enum representing different button sizes.
 */
enum class ButtonSize {
    /** Small button size */
    SMALL,
    /** Medium button size (default) */
    MEDIUM,
    /** Large button size */
    LARGE
}

/**
 * Configuration data class for EveryButton component.
 *
 * @param type The type of button to render
 * @param id Unique identifier for the button
 * @param text The text to display on the button
 * @param enabled Whether the button is enabled for interaction
 * @param fullWidth Whether the button should expand to fill available width
 * @param icon Optional icon name to display alongside text
 * @param size The size of the button
 */
data class EveryButtonConfig(
    val type: ButtonType,
    val id: String,
    val text: String,
    val enabled: Boolean = true,
    val fullWidth: Boolean = false,
    val icon: String? = null,
    val size: ButtonSize = ButtonSize.MEDIUM
)