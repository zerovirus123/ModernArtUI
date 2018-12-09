# ModernArtUI
Android application for displaying a multicolor UI. Part of Coursera's Programming Android Applications for Mobile Systems: Part 1.

# Building the Project

Android Studio is required for building the project in a GUI environment.

Follow the steps: File -> Import Project -> Choose Directory -> Import from external model -> Gradle -> Use default gradle wrapper -> Finish.

To build the project via terminal, use the gradle wrapper to build the application.

```chmod +x gradlew```

To build a debug version

```./gradlew assembleDebug```

To build a release version

```./gradlew assembleRelease```

Apk can be found at ```app/build/outputs/apk```
