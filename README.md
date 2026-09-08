# Which Is Cheaper? V2

An early Android/Kotlin game that asks players to choose the cheaper item from
two illustrated options. The repository targets Android API 28 and preserves
the original 2019 application code as a legacy portfolio project.

## Project state

The Gradle wrapper, root project, `settings.gradle`, and `app` module are all
present, so the checkout is structurally complete. It uses Android Gradle Plugin
3.4.1, Gradle 5.1.1, Kotlin 1.3.11, and the pre-AndroidX support libraries.
Those versions require a legacy Android/JDK toolchain and are not expected to
run on current JDK 21 without a deliberate AndroidX/Gradle migration.

## Legacy build

With Android SDK 28 installed and a compatible JDK (Java 8 was contemporary):

```bash
./gradlew test assembleDebug
```

Set the SDK location in an untracked `local.properties` file or through
`ANDROID_HOME`. Generated builds, Gradle caches, IDE metadata, and local SDK
paths are intentionally excluded from version control.
Unused template icons and scratch snippets have also been removed so the tree
contains only resources that ship in the application. Bitmap assets now use
Android's density-neutral resource directory, while launcher icons use the
existing density-specific mipmaps.

The car game now initialises its controls from the launched activity instance;
the previous code constructed a detached `Activity`, which could crash before
the game screen had created its views. Non-launcher activities are explicitly
kept internal to the app and application backup is disabled because the game
has no user data to preserve.

## Modernisation boundary

This cleanup restores a source-only repository and documents the known build
constraint. A future functional upgrade should migrate to AndroidX, a current
Android Gradle Plugin/Kotlin pair, and current target SDK as one tested change.
