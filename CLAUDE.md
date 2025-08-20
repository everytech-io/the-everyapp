# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Kotlin Multiplatform project using Compose Multiplatform for UI, targeting Android, iOS, Web (WASM), and Desktop (JVM). The project uses a single shared UI implementation across all platforms.

## Essential Commands

### Running the Application

**Desktop (JVM):**
```bash
./gradlew :composeApp:run
```

**Web (Browser):**
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

**Android:**
- Install on device/emulator: `./gradlew :composeApp:installDebug`
- Build APK: `./gradlew :composeApp:assembleDebug`

**iOS:**
- Open `iosApp/iosApp.xcodeproj` in Xcode and run
- Or use: `./gradlew :composeApp:linkDebugFrameworkIosSimulatorArm64` for simulator builds

### Testing

**Run all tests:**
```bash
./gradlew :composeApp:allTests
```

**Platform-specific tests:**
```bash
./gradlew :composeApp:jvmTest           # JVM tests
./gradlew :composeApp:iosSimulatorArm64Test  # iOS simulator tests
./gradlew :composeApp:wasmJsTest        # Web tests
./gradlew :composeApp:connectedAndroidTest   # Android instrumentation tests
```

### Build & Check

```bash
./gradlew build          # Build all targets
./gradlew check          # Run all checks
./gradlew clean          # Clean build artifacts
```

## Design System

### Material 3 Expressive Guidelines

This project uses **Material 3 Expressive** - Google's latest design system evolution with enhanced animations, shapes, and components. When implementing UI components, follow these principles:

#### **Component Standards**
- **Cards**: Use elevated style with 16dp corner radius, support morphing animations
- **Buttons**: Implement button groups with shape morphing and expressive motion
- **FAB**: Support FAB menu patterns with contrasting colors and large items
- **Loading**: Use new M3 Expressive loading indicators with smooth animations
- **Motion**: Apply `expressiveMotionScheme` for dynamic transitions and morphing
- **Shapes**: Utilize the 35 new expressive shapes with morphing capabilities
- **Colors**: Follow dynamic color schemes that adapt to light/dark themes

#### **Animation Requirements**
- Shape morphing for interactive elements
- Expressive motion timing (slower, more dramatic than standard)
- Coordinated group animations for related components
- Accessibility-first motion with reduced motion support

#### **SDUI Implementation**
- All components must be server-driven via JSON configuration
- Support Material 3 Expressive properties (corner radius, motion schemes, colors)
- Maintain consistency across all platforms (Android, iOS, Web, Desktop)
- Include proper semantic accessibility labels

## Architecture

### Multiplatform Structure

The codebase follows Kotlin Multiplatform's expect/actual pattern:

- **Common Code** (`composeApp/src/commonMain/`): Shared business logic and UI components using Compose Multiplatform
- **Platform-Specific** (`composeApp/src/{platform}Main/`): Platform implementations for expect declarations
  - `androidMain`: Android-specific code and resources
  - `iosMain`: iOS-specific Kotlin implementations
  - `jvmMain`: Desktop JVM implementations
  - `wasmJsMain`: Web/WASM implementations

### Key Components

**Core Application Entry Points:**
- `App.kt`: Main Compose UI component shared across all platforms
- `Platform.kt`: Platform abstraction interface with expect/actual implementations
- `Greeting.kt`: Sample business logic demonstrating platform detection

**Platform Integration:**
- Each platform has specific main entry points that initialize the shared App composable
- iOS uses a framework bridge pattern for SwiftUI integration
- Android uses standard Activity-based composition

### Package Structure

Base package: `io.everytech.everyapp`

The project uses Compose Resources for managing shared assets across platforms, with generated resource accessors in `everyapp.composeapp.generated.resources`.

## Development Workflow

### Hot Reload Support

The project includes Compose Hot Reload (version 1.0.0-beta04) for faster development cycles on JVM:
```bash
./gradlew :composeApp:reload
```

### Gradle Configuration

- **Memory Settings**: JVM args set to 4GB, Kotlin daemon to 3GB
- **Caching**: Configuration cache and build cache enabled for faster builds
- **Version Management**: Centralized in `gradle/libs.versions.toml`

### Platform Requirements

- **Android**: minSdk 24, targetSdk 35, compileSdk 35
- **iOS**: Supports arm64, x64, and simulator arm64
- **JVM**: Desktop distribution supports DMG, MSI, and DEB formats
- **Web**: WebAssembly with Kotlin/Wasm support