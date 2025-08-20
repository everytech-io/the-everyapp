# Material 3 Expressive Component JSON Schemas

This document defines simplified JSON structures for Material 3 Expressive components. The schemas focus on UI components and interactions only. Theme tokens are handled by the front-end application.

## Design Token System

### Spacing System
Following the M3 Expressive spacing scale with default being `medium`:
- **xs**: 4dp
- **small**: 8dp  
- **medium**: 16dp (default)
- **large**: 24dp
- **xlarge**: 32dp

### Shape System
Material 3 Expressive introduces **35 new shapes** with morphing capabilities, available in the Material Shapes Library (Figma) and Jetpack Compose.

#### Two Shape Systems Available:

##### 1. Corner Radius Tokens (Standard M3 Scale)
For basic rounded rectangle shapes:
- **none**: 0dp (sharp corners)
- **extraSmall**: 4dp
- **small**: 8dp
- **medium**: 12dp (default for cards)
- **large**: 16dp (default for FABs)
- **extraLarge**: 28dp (navigation, bottom sheets)
- **full**: 999dp (fully rounded - buttons, chips)

##### 2. Expressive Shape Set (35 Shapes)
Material 3 Expressive provides 35 distinctive shapes for more expressive designs:

**Note**: The complete list of 35 shapes is available in the [M3 Expressive Shapes Set on Figma](https://www.figma.com/community/file/1510597655879136621/m3-expressive-shapes-set). Common categories include:
- Organic shapes (squircles, blobs, waves)
- Geometric shapes (hexagons, diamonds, stars)
- Decorative shapes (hearts, flowers, gems)
- Interactive shapes (pills, capsules, badges)

#### Component Shape Assignments
Based on Material 3 Expressive specifications:
- **Buttons**: `full` or expressive shapes for branding
- **Cards**: `medium` (standard) or expressive shapes for differentiation
- **FAB**: `large` (standard) or expressive shapes for uniqueness
- **Images**: Any of the 35 expressive shapes for visual interest

#### Shape Morphing Support
All shapes support smooth morphing transitions, allowing components to transform from one shape to another for interactive feedback and visual delight.

## Component Schemas

---

## 1. Card Component

### Base Card Schema

```json
{
  "type": "card",
  "id": "card_unique_id",
  "variant": "elevated",
  "properties": {
    "elevation": "level2",
    "shape": "medium",
    "padding": "medium",
    "margin": "small",
    "width": "match_parent",
    "height": "wrap_content"
  },
  "interaction": {
    "clickable": true,
    "onTap": {
      "action": "navigate",
      "destination": "/details"
    }
  },
  "accessibility": {
    "contentDescription": "Product card",
    "semanticRole": "button"
  },
  "content": [
    {
      "type": "column",
      "children": []
    }
  ]
}
```

### Card Shape Examples

#### Standard Card (Corner Radius Token)
```json
{
  "variant": "elevated",
  "properties": {
    "shape": "medium",
    "elevation": "level2"
  }
}
```

#### Expressive Card (Organic Shape)
```json
{
  "variant": "filled",
  "properties": {
    "shape": "squircle",
    "elevation": "level0"
  }
}
```

#### Branded Card (Geometric Shape)
```json
{
  "variant": "outlined",
  "properties": {
    "shape": "hexagon",
    "elevation": "level0",
    "borderWidth": 1
  }
}
```

#### Interactive Card with Shape Morphing
```json
{
  "variant": "elevated",
  "properties": {
    "shape": "medium",
    "morphTarget": "squircle",
    "morphTrigger": "hover",
    "elevation": "level3"
  }
}
```

---

## 2. Text Component

Text follows M3 Expressive typography scale with enhanced expressiveness and dynamic color theming.

### Base Text Schema

```json
{
  "type": "text",
  "id": "text_unique_id", 
  "text": "Hello World",
  "properties": {
    "style": "bodyLarge",
    "weight": "normal",
    "textAlign": "start",
    "maxLines": null,
    "overflow": "ellipsis",
    "padding": "none",
    "margin": "none"
  },
  "interaction": {
    "selectable": false,
    "clickable": false,
    "onTap": null
  },
  "accessibility": {
    "contentDescription": null,
    "semanticRole": "text"
  }
}
```

### Typography Styles

#### Display Styles
```json
{
  "displayLarge": { "size": 57, "lineHeight": 64, "weight": "normal" },
  "displayMedium": { "size": 45, "lineHeight": 52, "weight": "normal" },
  "displaySmall": { "size": 36, "lineHeight": 44, "weight": "normal" }
}
```

#### Headline Styles  
```json
{
  "headlineLarge": { "size": 32, "lineHeight": 40, "weight": "normal" },
  "headlineMedium": { "size": 28, "lineHeight": 36, "weight": "normal" },
  "headlineSmall": { "size": 24, "lineHeight": 32, "weight": "normal" }
}
```

#### Title Styles
```json
{
  "titleLarge": { "size": 22, "lineHeight": 28, "weight": "medium" },
  "titleMedium": { "size": 16, "lineHeight": 24, "weight": "medium" },
  "titleSmall": { "size": 14, "lineHeight": 20, "weight": "medium" }
}
```

#### Body Styles
```json
{
  "bodyLarge": { "size": 16, "lineHeight": 24, "weight": "normal" },
  "bodyMedium": { "size": 14, "lineHeight": 20, "weight": "normal" },
  "bodySmall": { "size": 12, "lineHeight": 16, "weight": "normal" }
}
```

#### Label Styles
```json
{
  "labelLarge": { "size": 14, "lineHeight": 20, "weight": "medium" },
  "labelMedium": { "size": 12, "lineHeight": 16, "weight": "medium" },
  "labelSmall": { "size": 11, "lineHeight": 16, "weight": "medium" }
}
```

---

## 3. Image Component

Images in M3 Expressive support dynamic theming, shape morphing, and accessibility features.

### Base Image Schema

```json
{
  "type": "image",
  "id": "image_unique_id",
  "source": {
    "url": "https://example.com/image.jpg",
    "placeholder": "https://example.com/placeholder.jpg",
    "error": "https://example.com/error.jpg"
  },
  "properties": {
    "width": "match_parent",
    "height": "200dp",
    "aspectRatio": "16:9",
    "contentScale": "crop",
    "shape": "medium",
    "alpha": 1.0
  },
  "interaction": {
    "clickable": false,
    "onTap": null
  },
  "accessibility": {
    "contentDescription": "Product image",
    "semanticRole": "image"
  }
}
```

### Content Scale Options
```json
{
  "contentScale": {
    "crop": "Center crop maintaining aspect ratio",
    "fit": "Scale to fit entirely within bounds", 
    "fillWidth": "Scale to fill width, crop height if needed",
    "fillHeight": "Scale to fill height, crop width if needed",
    "none": "No scaling, original size",
    "inside": "Scale down only if larger than bounds"
  }
}
```

### Shape Examples in Practice

#### Avatar Image (Standard Rounded)
```json
{
  "type": "image",
  "properties": {
    "shape": "full",
    "width": "40dp",
    "height": "40dp"
  }
}
```

#### Expressive Avatar (Custom Shape)
```json
{
  "type": "image", 
  "properties": {
    "shape": "squircle",
    "width": "40dp",
    "height": "40dp"
  }
}
```

#### Hero Image with Geometric Shape
```json
{
  "type": "image",
  "properties": {
    "shape": "hexagon",
    "aspectRatio": "16:9"
  }
}
```

#### Decorative Image Element
```json
{
  "type": "image",
  "properties": {
    "shape": "star",
    "width": "80dp",
    "height": "80dp"
  }
}
```


## Usage Guidelines

### Interaction Actions
Supported action types:
- `"navigate"`: Navigate to a destination 
- `"callback"`: Trigger a callback function
- `"none"`: No action

### Token Reference
Components reference design tokens using string keys:
- **Spacing**: `"xs"`, `"small"`, `"medium"`, `"large"`, `"xlarge"`
- **Standard Shapes**: `"none"`, `"extraSmall"`, `"small"`, `"medium"`, `"large"`, `"extraLarge"`, `"full"`
- **Expressive Shapes**: Any of the 35 M3 Expressive shapes (e.g., `"squircle"`, `"hexagon"`, `"star"`, `"wave"`)
- **Elevation**: `"level0"` through `"level5"`

### Shape Morphing Properties
For components supporting shape transitions:
```json
{
  "properties": {
    "shape": "medium",
    "morphTarget": "large",
    "morphTrigger": "hover"
  }
}
```

**morphTrigger** options:
- `"hover"`: Shape morphs on hover/focus
- `"press"`: Shape morphs on press/tap
- `"selection"`: Shape morphs when selected
- `"loading"`: Shape morphs during loading states

### Accessibility Requirements
- Include `contentDescription` for screen readers
- Use appropriate `semanticRole` values
- Ensure interactive elements are properly marked

This simplified schema focuses purely on UI structure and interactions, leaving theme implementation to the front-end.