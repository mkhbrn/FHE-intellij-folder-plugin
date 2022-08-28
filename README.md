# FHE-intellij-folder-plugin

![Build](https://github.com/KhbrnDev/FHE-intellij-folder-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Achieved
- can fold folders
- storage retains folded folders after restart
- storage retains custom set separators


## TODO
- 1 File composed
- all files in folder composed
- composing only one level
- composing all levels
  - für jede Datei speichern bis zu welchem Level die Datei aufgeilt wird
- overridable functions and what they do

<details> <summary>Wiki</summary>

Doenst work for source files e.g. `.kt .kts .class`

Works for `.xml .json .html .sql .txt`

This warning can be safely ignored as of [this thread](https://intellij-support.jetbrains.com/hc/en-us/community/posts/360010413299-Unexplained-Illegal-Reflective-Access-Operation-on-JreHiDpiUtil)

```WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.intellij.ui.JreHiDpiUtil to method sun.java2d.SunGraphicsEnvironment.isUIScaleEnabled()
WARNING: Please consider reporting this to the maintainers of com.intellij.ui.JreHiDpiUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
2022-04-30 12:28:07,028 [   1546]   WARN - j.internal.DebugAttachDetector - Unable to start DebugAttachDetector, please add `--add-exports java.base/jdk.internal.vm=ALL-UNNAMED` to VM options 
```

action.getData([Example_Keys](https://upsource.jetbrains.com/idea-ce/file/idea-ce-4d741bc560dd19306d4624d7c8a88aea537f4e6f/platform/editor-ui-api/src/com/intellij/openapi/actionSystem/CommonDataKeys.java?_ga=2.128695436.1017619852.1651310593-1403583720.1649957955))


</details>


<details> <summary>Settings</summary>

Settings can be found under **File** -> **Settings...** -> **Tools** -> **Khbrn - Folding**

- file level separator can be edited
- 


</details>



## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "FHE-intellij-folder-plugin"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/KhbrnDev/FHE-intellij-folder-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
