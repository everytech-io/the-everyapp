package io.everytech.everyapp.service

import io.everytech.everyapp.data.*
import kotlinx.coroutines.delay

class MockAPIService {
    
    suspend fun generateUIFromPrompt(prompt: String): EveryAppData {
        // Simulate API call delay
        delay(2000)
        
        return when {
            prompt.contains("calorie", ignoreCase = true) || prompt.contains("fitness", ignoreCase = true) || prompt.contains("health", ignoreCase = true) -> createCalorieTrackerApp()
            prompt.contains("ecommerce", ignoreCase = true) || prompt.contains("store", ignoreCase = true) || prompt.contains("shop", ignoreCase = true) -> createEcommerceApp()
            prompt.contains("banking", ignoreCase = true) || prompt.contains("finance", ignoreCase = true) || prompt.contains("wallet", ignoreCase = true) -> createBankingApp()
            prompt.contains("social", ignoreCase = true) || prompt.contains("feed", ignoreCase = true) || prompt.contains("post", ignoreCase = true) -> createSocialApp()
            prompt.contains("music", ignoreCase = true) || prompt.contains("player", ignoreCase = true) || prompt.contains("spotify", ignoreCase = true) -> createMusicApp()
            prompt.contains("recipe", ignoreCase = true) || prompt.contains("cooking", ignoreCase = true) || prompt.contains("food", ignoreCase = true) -> createRecipeApp()
            else -> createDefaultApp()
        }
    }
    
    private fun createCalorieTrackerApp(): EveryAppData {
        return EveryAppData(
            id = "calorie_tracker_app",
            title = "FitTrack",
            screens = listOf(
                EveryScreenData(
                    id = "home_screen",
                    title = "Daily Progress",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryTextData(
                            id = "greeting",
                            text = "Good morning, Sarah! 🌅",
                            style = EveryTextStyle(variant = "headlineLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryCardData(
                            id = "daily_progress",
                            title = "Today's Progress",
                            subtitle = "1,847 / 2,200 calories",
                            content = "You're doing great! 353 calories remaining.",
                            style = EveryCardStyle(
                                elevation = 2,
                                cornerRadius = 16,
                                contentPadding = EverySpacingData(horizontal = 20, vertical = 20)
                            ),
                            actions = listOf(
                                EveryActionData(id = "add_meal", text = "Add Meal", type = "primary"),
                                EveryActionData(id = "details", text = "View Details", type = "secondary")
                            ),
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryGridData(
                            id = "macros_grid",
                            columns = 3,
                            style = EveryGridStyle(
                                itemSpacing = 12,
                                aspectRatio = "1:1"
                            ),
                            items = listOf(
                                EveryCardData(
                                    id = "protein_card",
                                    title = "Protein",
                                    content = "87g",
                                    subtitle = "of 120g",
                                    style = EveryCardStyle(elevation = 1, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "carbs_card",
                                    title = "Carbs",
                                    content = "165g",
                                    subtitle = "of 200g",
                                    style = EveryCardStyle(elevation = 1, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "fat_card",
                                    title = "Fat",
                                    content = "45g",
                                    subtitle = "of 60g",
                                    style = EveryCardStyle(elevation = 1, cornerRadius = 16)
                                )
                            ),
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryListData(
                            id = "recent_meals",
                            style = EveryListStyle(
                                dividers = true,
                                cornerRadius = 16,
                                itemPadding = EverySpacingData(horizontal = 16, vertical = 12)
                            ),
                            items = listOf(
                                EveryListItemData(
                                    id = "breakfast",
                                    title = "Breakfast",
                                    subtitle = "Oatmeal with berries - 380 cal",
                                    icon = "🥣"
                                ),
                                EveryListItemData(
                                    id = "lunch", 
                                    title = "Lunch",
                                    subtitle = "Grilled chicken salad - 420 cal",
                                    icon = "🥗"
                                ),
                                EveryListItemData(
                                    id = "snack",
                                    title = "Snack",
                                    subtitle = "Apple with peanut butter - 180 cal",
                                    icon = "🍎"
                                )
                            )
                        )
                    )
                )
            ),
            navigation = EveryNavigationData(
                id = "main_nav",
                type = "bottom",
                style = EveryNavigationStyle(height = 80, elevation = 3),
                items = listOf(
                    EveryNavigationItemData("home", "Home", "🏠", selected = true),
                    EveryNavigationItemData("meals", "Meals", "🍽️"),
                    EveryNavigationItemData("exercise", "Exercise", "🏃"),
                    EveryNavigationItemData("profile", "Profile", "👤")
                ),
                spacing = EverySpacingData()
            )
        )
    }
    
    private fun createEcommerceApp(): EveryAppData {
        return EveryAppData(
            id = "ecommerce_app",
            title = "TechStore",
            screens = listOf(
                EveryScreenData(
                    id = "store_screen",
                    title = "Store",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryTextData(
                            id = "store_title",
                            text = "TechStore",
                            style = EveryTextStyle(variant = "headlineLarge", weight = "bold"),
                            alignment = "center",
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryCardData(
                            id = "flash_sale",
                            title = "🔥 Flash Sale",
                            subtitle = "50% off wireless earbuds",
                            content = "Limited time offer - ends in 4 hours!",
                            style = EveryCardStyle(
                                elevation = 3,
                                cornerRadius = 20,
                                backgroundColor = "#FF6B6B",
                                contentPadding = EverySpacingData(horizontal = 24, vertical = 20)
                            ),
                            actions = listOf(
                                EveryActionData(id = "shop_now", text = "Shop Now", type = "primary")
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "categories_label",
                            text = "Categories",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryGridData(
                            id = "categories_grid",
                            columns = 2,
                            style = EveryGridStyle(
                                itemSpacing = 16,
                                aspectRatio = "4:3"
                            ),
                            items = listOf(
                                EveryCardData(
                                    id = "smartphones",
                                    title = "Smartphones",
                                    content = "📱",
                                    subtitle = "Latest models",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "laptops",
                                    title = "Laptops", 
                                    content = "💻",
                                    subtitle = "Gaming & Work",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "audio",
                                    title = "Audio",
                                    content = "🎧",
                                    subtitle = "Headphones & Speakers",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "accessories",
                                    title = "Accessories",
                                    content = "🔌",
                                    subtitle = "Cases & Cables", 
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                )
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "trending_label",
                            text = "Trending Products",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryListData(
                            id = "trending_products",
                            style = EveryListStyle(
                                dividers = false,
                                cornerRadius = 16,
                                itemPadding = EverySpacingData(horizontal = 16, vertical = 16)
                            ),
                            items = listOf(
                                EveryListItemData(
                                    id = "iphone",
                                    title = "iPhone 15 Pro",
                                    subtitle = "$999 • 4.8★ (2.1k reviews)",
                                    icon = "📱",
                                    trailing = "❤️"
                                ),
                                EveryListItemData(
                                    id = "macbook",
                                    title = "MacBook Air M3",
                                    subtitle = "$1,299 • 4.9★ (1.5k reviews)",
                                    icon = "💻",
                                    trailing = "❤️"
                                ),
                                EveryListItemData(
                                    id = "airpods",
                                    title = "AirPods Pro 2",
                                    subtitle = "$249 • 4.7★ (3.2k reviews)", 
                                    icon = "🎧",
                                    trailing = "❤️"
                                )
                            )
                        )
                    )
                )
            ),
            navigation = EveryNavigationData(
                id = "store_nav",
                type = "bottom",
                style = EveryNavigationStyle(height = 80, elevation = 3),
                items = listOf(
                    EveryNavigationItemData("home", "Home", "🏠", selected = true),
                    EveryNavigationItemData("search", "Search", "🔍"),
                    EveryNavigationItemData("cart", "Cart", "🛒", badgeCount = 3),
                    EveryNavigationItemData("account", "Account", "👤")
                ),
                spacing = EverySpacingData()
            )
        )
    }
    
    private fun createBankingApp(): EveryAppData {
        return EveryAppData(
            id = "banking_app",
            title = "SecureBank",
            screens = listOf(
                EveryScreenData(
                    id = "banking_screen",
                    title = "Banking",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryTextData(
                            id = "greeting",
                            text = "Hello, Alex 👋",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryCardData(
                            id = "balance_card",
                            title = "Total Balance",
                            content = "$12,847.32",
                            subtitle = "+$247.18 this month",
                            style = EveryCardStyle(
                                elevation = 3,
                                cornerRadius = 24,
                                backgroundColor = "#4CAF50",
                                contentPadding = EverySpacingData(horizontal = 24, vertical = 24)
                            ),
                            actions = listOf(
                                EveryActionData(id = "send", text = "Send", type = "primary"),
                                EveryActionData(id = "request", text = "Request", type = "secondary")
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryGridData(
                            id = "quick_actions",
                            columns = 4,
                            style = EveryGridStyle(
                                itemSpacing = 16,
                                aspectRatio = "1:1"
                            ),
                            items = listOf(
                                EveryCardData(
                                    id = "transfer",
                                    title = "Transfer",
                                    content = "💸",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "pay_bills",
                                    title = "Pay Bills",
                                    content = "📄",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "deposit",
                                    title = "Deposit",
                                    content = "📥",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "invest",
                                    title = "Invest",
                                    content = "📈",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                )
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "transactions_label",
                            text = "Recent Transactions",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryListData(
                            id = "transactions",
                            style = EveryListStyle(
                                dividers = true,
                                cornerRadius = 16,
                                itemPadding = EverySpacingData(horizontal = 16, vertical = 12)
                            ),
                            items = listOf(
                                EveryListItemData(
                                    id = "spotify",
                                    title = "Spotify Premium",
                                    subtitle = "Dec 8 • Subscription",
                                    icon = "🎵",
                                    trailing = "-$12.99"
                                ),
                                EveryListItemData(
                                    id = "salary",
                                    title = "TechCorp Inc.",
                                    subtitle = "Dec 7 • Salary",
                                    icon = "🏢",
                                    trailing = "+$4,250.00"
                                ),
                                EveryListItemData(
                                    id = "coffee",
                                    title = "Starbucks",
                                    subtitle = "Dec 7 • Food & Drink",
                                    icon = "☕",
                                    trailing = "-$5.47"
                                )
                            )
                        )
                    )
                )
            )
        )
    }
    
    private fun createSocialApp(): EveryAppData {
        return EveryAppData(
            id = "social_app",
            title = "SocialConnect",
            screens = listOf(
                EveryScreenData(
                    id = "feed_screen",
                    title = "Feed",
                    padding = EverySpacingData(horizontal = 16, vertical = 16),
                    components = listOf(
                        EveryTextData(
                            id = "app_title",
                            text = "SocialConnect",
                            style = EveryTextStyle(variant = "titleLarge", weight = "bold"),
                            alignment = "center",
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryCardData(
                            id = "story_prompt",
                            title = "Share your story",
                            content = "What's on your mind, Sarah?",
                            style = EveryCardStyle(
                                elevation = 1,
                                cornerRadius = 16,
                                strokeWidth = 1
                            ),
                            actions = listOf(
                                EveryActionData(id = "photo", text = "📷 Photo", type = "secondary"),
                                EveryActionData(id = "video", text = "📹 Video", type = "secondary")
                            ),
                            spacing = EverySpacingData(bottom = 24)
                        ),
                        EveryCardData(
                            id = "post_1",
                            title = "Alex Johnson",
                            subtitle = "2 hours ago",
                            content = "Just finished an amazing hike in the mountains! The view was incredible 🏔️ #nature #hiking",
                            style = EveryCardStyle(elevation = 2, cornerRadius = 16),
                            actions = listOf(
                                EveryActionData(id = "like", text = "❤️ 24", type = "tertiary"),
                                EveryActionData(id = "comment", text = "💬 8", type = "tertiary"),
                                EveryActionData(id = "share", text = "📤 Share", type = "tertiary")
                            ),
                            spacing = EverySpacingData(bottom = 20)
                        ),
                        EveryCardData(
                            id = "post_2",
                            title = "Maria Garcia",
                            subtitle = "4 hours ago",
                            content = "New recipe alert! 🍝 Made this delicious pasta dish tonight. Recipe in comments!",
                            style = EveryCardStyle(elevation = 2, cornerRadius = 16),
                            actions = listOf(
                                EveryActionData(id = "like", text = "❤️ 156", type = "tertiary"),
                                EveryActionData(id = "comment", text = "💬 23", type = "tertiary"),
                                EveryActionData(id = "share", text = "📤 Share", type = "tertiary")
                            ),
                            spacing = EverySpacingData(bottom = 20)
                        )
                    )
                )
            ),
            navigation = EveryNavigationData(
                id = "social_nav",
                type = "bottom",
                style = EveryNavigationStyle(height = 80, elevation = 3),
                items = listOf(
                    EveryNavigationItemData("home", "Home", "🏠", selected = true),
                    EveryNavigationItemData("search", "Search", "🔍"),
                    EveryNavigationItemData("create", "Create", "➕"),
                    EveryNavigationItemData("notifications", "Alerts", "🔔", badgeCount = 3),
                    EveryNavigationItemData("profile", "Profile", "👤")
                ),
                spacing = EverySpacingData()
            )
        )
    }
    
    private fun createMusicApp(): EveryAppData {
        return EveryAppData(
            id = "music_app",
            title = "MusicStream",
            screens = listOf(
                EveryScreenData(
                    id = "music_screen",
                    title = "Music",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryTextData(
                            id = "app_title",
                            text = "MusicStream",
                            style = EveryTextStyle(variant = "headlineLarge", weight = "bold"),
                            alignment = "center",
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryCardData(
                            id = "now_playing",
                            title = "Now Playing",
                            subtitle = "Bohemian Rhapsody",
                            content = "Queen • A Night at the Opera",
                            style = EveryCardStyle(
                                elevation = 3,
                                cornerRadius = 24,
                                backgroundColor = "#9C27B0",
                                contentPadding = EverySpacingData(horizontal = 24, vertical = 24)
                            ),
                            actions = listOf(
                                EveryActionData(id = "previous", text = "⏮️", type = "secondary"),
                                EveryActionData(id = "play_pause", text = "⏸️", type = "primary"),
                                EveryActionData(id = "next", text = "⏭️", type = "secondary"),
                                EveryActionData(id = "favorite", text = "❤️", type = "tertiary")
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "playlists_label",
                            text = "Your Playlists",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryGridData(
                            id = "playlists_grid",
                            columns = 2,
                            style = EveryGridStyle(
                                itemSpacing = 16,
                                aspectRatio = "1:1"
                            ),
                            items = listOf(
                                EveryCardData(
                                    id = "rock_classics",
                                    title = "Rock Classics",
                                    content = "🎸",
                                    subtitle = "87 songs",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "chill_vibes",
                                    title = "Chill Vibes",
                                    content = "🎵",
                                    subtitle = "43 songs",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "workout",
                                    title = "Workout Mix",
                                    content = "💪",
                                    subtitle = "62 songs",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                ),
                                EveryCardData(
                                    id = "favorites",
                                    title = "Favorites",
                                    content = "❤️",
                                    subtitle = "124 songs",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 20)
                                )
                            )
                        )
                    )
                )
            ),
            navigation = EveryNavigationData(
                id = "music_nav",
                type = "bottom",
                style = EveryNavigationStyle(height = 80, elevation = 3),
                items = listOf(
                    EveryNavigationItemData("home", "Home", "🏠", selected = true),
                    EveryNavigationItemData("search", "Search", "🔍"),
                    EveryNavigationItemData("library", "Library", "📚"),
                    EveryNavigationItemData("radio", "Radio", "📻")
                ),
                spacing = EverySpacingData()
            )
        )
    }
    
    private fun createRecipeApp(): EveryAppData {
        return EveryAppData(
            id = "recipe_app",
            title = "CookMaster",
            screens = listOf(
                EveryScreenData(
                    id = "recipe_screen",
                    title = "Recipes",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryTextData(
                            id = "greeting",
                            text = "What shall we cook today? 👨‍🍳",
                            style = EveryTextStyle(variant = "headlineLarge", weight = "medium"),
                            alignment = "center",
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryCardData(
                            id = "featured_recipe",
                            title = "Recipe of the Day",
                            subtitle = "Creamy Mushroom Risotto",
                            content = "A rich and creamy Italian classic that's perfect for dinner. Ready in 35 minutes!",
                            style = EveryCardStyle(
                                elevation = 3,
                                cornerRadius = 20,
                                backgroundColor = "#FF9800",
                                contentPadding = EverySpacingData(horizontal = 24, vertical = 20)
                            ),
                            actions = listOf(
                                EveryActionData(id = "cook_now", text = "Cook Now", type = "primary"),
                                EveryActionData(id = "save", text = "Save", type = "secondary")
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "categories_label",
                            text = "Browse Categories",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryGridData(
                            id = "categories_grid",
                            columns = 3,
                            style = EveryGridStyle(
                                itemSpacing = 12,
                                aspectRatio = "1:1"
                            ),
                            items = listOf(
                                EveryCardData(
                                    id = "breakfast",
                                    title = "Breakfast",
                                    content = "🥞",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "lunch",
                                    title = "Lunch",
                                    content = "🥗",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "dinner",
                                    title = "Dinner",
                                    content = "🍝",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "dessert",
                                    title = "Dessert",
                                    content = "🍰",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "snacks",
                                    title = "Snacks",
                                    content = "🍿",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                ),
                                EveryCardData(
                                    id = "drinks",
                                    title = "Drinks",
                                    content = "🥤",
                                    style = EveryCardStyle(elevation = 2, cornerRadius = 16)
                                )
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryListData(
                            id = "trending_recipes",
                            style = EveryListStyle(
                                dividers = false,
                                cornerRadius = 16,
                                itemPadding = EverySpacingData(horizontal = 16, vertical = 16)
                            ),
                            items = listOf(
                                EveryListItemData(
                                    id = "pasta",
                                    title = "Spaghetti Carbonara",
                                    subtitle = "25 min • 4.8★ • Italian",
                                    icon = "🍝",
                                    trailing = "❤️"
                                ),
                                EveryListItemData(
                                    id = "steak", 
                                    title = "Grilled Ribeye Steak",
                                    subtitle = "20 min • 4.9★ • American",
                                    icon = "🥩",
                                    trailing = "❤️"
                                ),
                                EveryListItemData(
                                    id = "curry",
                                    title = "Thai Green Curry",
                                    subtitle = "40 min • 4.7★ • Thai",
                                    icon = "🍛",
                                    trailing = "❤️"
                                )
                            )
                        )
                    )
                )
            ),
            navigation = EveryNavigationData(
                id = "recipe_nav",
                type = "bottom",
                style = EveryNavigationStyle(height = 80, elevation = 3),
                items = listOf(
                    EveryNavigationItemData("home", "Home", "🏠", selected = true),
                    EveryNavigationItemData("search", "Search", "🔍"),
                    EveryNavigationItemData("favorites", "Favorites", "❤️"),
                    EveryNavigationItemData("profile", "Profile", "👤")
                ),
                spacing = EverySpacingData()
            )
        )
    }
    
    private fun createDefaultApp(): EveryAppData {
        return EveryAppData(
            id = "default_app",
            title = "EveryApp Demo",
            screens = listOf(
                EveryScreenData(
                    id = "welcome_screen",
                    title = "Welcome",
                    padding = EverySpacingData(horizontal = 16, vertical = 24),
                    components = listOf(
                        EveryCardData(
                            id = "welcome_card",
                            title = "Welcome to EveryApp! 🚀",
                            content = "Your AI-powered app has been generated using Material 3 Expressive design tokens.",
                            style = EveryCardStyle(
                                elevation = 3,
                                cornerRadius = 20,
                                contentPadding = EverySpacingData(horizontal = 24, vertical = 24)
                            ),
                            actions = listOf(
                                EveryActionData(id = "explore", text = "Explore Features", type = "primary"),
                                EveryActionData(id = "customize", text = "Customize", type = "secondary")
                            ),
                            spacing = EverySpacingData(bottom = 32)
                        ),
                        EveryTextData(
                            id = "examples_title",
                            text = "Try These Examples:",
                            style = EveryTextStyle(variant = "titleLarge", weight = "medium"),
                            spacing = EverySpacingData(bottom = 16)
                        ),
                        EveryListData(
                            id = "examples_list",
                            style = EveryListStyle(
                                dividers = false,
                                cornerRadius = 16,
                                itemPadding = EverySpacingData(horizontal = 16, vertical = 16)
                            ),
                            items = listOf(
                                EveryListItemData(
                                    id = "ex1",
                                    title = "'Create a calorie tracker app'",
                                    subtitle = "Health & fitness tracking",
                                    icon = "🏃"
                                ),
                                EveryListItemData(
                                    id = "ex2",
                                    title = "'Build an ecommerce store'",
                                    subtitle = "Online shopping experience",
                                    icon = "🛒"
                                ),
                                EveryListItemData(
                                    id = "ex3",
                                    title = "'Make a banking app'",
                                    subtitle = "Financial management",
                                    icon = "💰"
                                ),
                                EveryListItemData(
                                    id = "ex4",
                                    title = "'Design a music player'",
                                    subtitle = "Streaming & playlists",
                                    icon = "🎵"
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}