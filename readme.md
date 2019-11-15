## GDScript plugin for IntelliJ IDEA

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]](license) 

![Type completion](https://i.imgur.com/hhhZFAl.png)
![File completion](https://i.imgur.com/i6u0KAD.png)
![Missing file warning](https://i.imgur.com/OKM93A9.png)
![Null keyword completion](https://i.imgur.com/NsQ3QWI.png)
![Constant value lookups like PI](https://i.imgur.com/2x7MrNl.png)
![Class name completion](https://i.imgur.com/5j9MzWO.png)

### Features

* Syntax highlighting (`.gd`, `.tres`) 
* Code completion of Godot Engine built-in classes, functions and static methods
* Path to file completion/validation 
* Auto-insertion of braces, brackets and quotes
* Code commenting (`Ctrl+/`)
* Syntax-aware code selection (`Ctrl+W` / `Ctrl+Shift+W`)
* Paired brackets highlighting

### Installation

1. Run `./gradlew buildPlugin` or [download latest release][plugin-url].
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` (or downloaded file) and restart.

Plugin is compatible with all IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required to update changes in ANTLR sources (`src/main/antlr/*.g4`).
* `./gradlew generateCompletion` - download & generate completion  `src/main/resources/completion.json`.
* `./gradlew test` - run all tests.
* `./gradlew publishPlugin` - publish plugin to JetBrains repository (token required in `gradle.properties`).

Contributions are welcome!

[plugin-url]: https://github.com/exigow/intellij-gdscript/releases
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
