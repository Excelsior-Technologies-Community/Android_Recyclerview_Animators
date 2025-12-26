## RecyclerView Animators (Kotlin)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![API](https://img.shields.io/badge/API-24%2B-orange)](#)
---

A lightweight, easy-to-use RecyclerView ItemAnimator library written in Kotlin to add smooth, modern animations when items are inserted or removed from a RecyclerView.

Designed to be simple, predictable, and developer-friendly.

### Features

- Clean Kotlin implementation
- Fade, Slide & Scale animations
- Customizable animation duration, delay & distance
- XML-based configuration (optional)
- No third-party dependencies
- RecyclerView reuse safe (no flicker)
- Demo app included

## Installation (JitPack)

### 1️⃣ Add JitPack to your **root `settings.gradle` or `build.gradle`**

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Add Dependency
```


```

---

## Usage

### XML Usage

```xml
<com.ext.recyclerviewanimators.RecyclerViewAnimator
    android:id="@+id/recyclerView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:ra_animatorType="slide_bottom"
    app:ra_duration="500"
    app:ra_delay="80"
    app:ra_distance="80dp"/>
```

### Kotlin Usage

```kotlin
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = adapter

recyclerView.itemAnimator = SlideInBottomAnimator()
```

Customization in Kotlin
```
recyclerView.itemAnimator = SlideInBottomAnimator(
    distance = 80f,
    durationMillis = 500,
    delayMillis = 50
)
```

### Insert items to trigger animation:
```
adapter.addItems(
    List(20) { "Item #$it" }
)
```

### Important Note (Very Important)
RecyclerView item animations run ONLY when items are added, removed, moved, or changed.

❌ Animations will NOT run on the initial adapter set.

This is RecyclerView’s default behavior, not a library limitation.

To see animations, always insert items using:
```
notifyItemInserted()
notifyItemRangeInserted()
```

### Available Animators

```
recyclerView.itemAnimator = FadeInAnimator() // Fade In Animation
recyclerView.itemAnimator = SlideInBottomAnimator() // Slide In From Bottom
recyclerView.itemAnimator = ScaleInAnimator() // Scale In Animation
```

---

## XML Attributes

| Attribute Name        | Description                                   | Format     | Default Value |
|----------------------|-----------------------------------------------|------------|---------------|
| `ra_animatorType`    | Type of item animation to apply               | enum       | `fade`        |
| `ra_duration`        | Animation duration in milliseconds            | integer    | `300`         |
| `ra_delay`           | Delay before animation starts (milliseconds)  | integer    | `0`           |
| `ra_distance`        | Slide distance (only for slide animation)     | dimension  | `60dp`        |


---

## License

```
MIT License

Copyright (c) 2025 Excelsior Technologies 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

