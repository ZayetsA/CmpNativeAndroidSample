# Compose Multiplatform Integration with Native Android Compose Project

This project demonstrates how to integrate a **Compose Multiplatform (CMP)** module into a native Android application. The shared module contains UI components and business logic written in Kotlin, making it reusable across platforms.

---

## Key Principles of Integration

1. **Project Structure**
   - **`commonMain`**: Shared code, including UI components and business logic.
   - **`androidMain`**: Android-specific implementations and dependencies.

2. **Setup in Android App**
   - Add the shared CMP module as a dependency in your Android project:
     ```kotlin
     dependencies {
         implementation(project(":composeApp"))
     }
     ```

3. **Embedding a Shared Composable**
   - Use `setContent` in your Android `Activity` or `Fragment` to display the shared composable:
     ```kotlin
      @Preview
      @Composable
      fun AppAndroidPreview() {
          App()
      }
     ```

4. **Syncing State Between Native and Shared Code**
   - Use a shared `ViewModel` or pass platform-specific data to your composables using parameters.

---

## Gradle Configuration

Add the necessary Compose and Multiplatform dependencies in your shared module's `build.gradle.kts`:
```kotlin
kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
}
