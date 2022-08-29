# FHE-intellij-folder-plugin

![Build](https://github.com/KhbrnDev/FHE-intellij-folder-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Download](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://github.com/mkhbrn/FHE-intellij-folder-plugin/releases/latest)




This warning can be safely ignored as of [this thread](https://intellij-support.jetbrains.com/hc/en-us/community/posts/360010413299-Unexplained-Illegal-Reflective-Access-Operation-on-JreHiDpiUtil)

```WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.intellij.ui.JreHiDpiUtil to method sun.java2d.SunGraphicsEnvironment.isUIScaleEnabled()
WARNING: Please consider reporting this to the maintainers of com.intellij.ui.JreHiDpiUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
2022-04-30 12:28:07,028 [   1546]   WARN - j.internal.DebugAttachDetector - Unable to start DebugAttachDetector, please add `--add-exports java.base/jdk.internal.vm=ALL-UNNAMED` to VM options 
```

action.getData([Example_Keys](https://upsource.jetbrains.com/idea-ce/file/idea-ce-4d741bc560dd19306d4624d7c8a88aea537f4e6f/platform/editor-ui-api/src/com/intellij/openapi/actionSystem/CommonDataKeys.java?_ga=2.128695436.1017619852.1651310593-1403583720.1649957955))




<!-- Plugin description -->
This Plugin folds folders by restructuring the tree structure.

Filenames are seperated by delimiters and create new folders.
Curently only one seperator can be used.
Seperators can be edited under Settings -> Tools -> mkhbrn - Folding Plugin

Works with .xml, .json, .txt, .sql and .html files.
Does not work for .kt, .kts, .class files  
<!-- Plugin description end -->

## Installation

  
- Manually:

  Download the [latest release](https://github.com/mkhbrn/FHE-intellij-folder-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
