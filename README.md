# FHE-intellij-folder-plugin

The Plugin was created as part of a university course at [FHE](https://www.ai.fh-erfurt.de/)
It is supposed to be used in AndroidStudio in the ProjectView (not working on Android) to make it easier to find files
in the resources' layout folder.

- [how it works](https://github.com/mkhbrn/FHE-intellij-folder-plugin/wiki#how-it-works)

<!-- Plugin description -->
This Plugin folds folders by restructuring the tree structure.

Filenames are seperated by delimiters and create new folders. Currently, only one separator can be used. Separators can
be edited under Settings -> Tools -> mkhbrn - Folding Plugin

Works with .xml, .json, .txt, .sql and .html files. Does not work for .kt, .kts, .class files
<!-- Plugin description end -->

## Installation

- Manually:

  Download the [latest release](https://github.com/mkhbrn/FHE-intellij-folder-plugin/releases/latest) and install it
  manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
