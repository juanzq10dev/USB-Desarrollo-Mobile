# Model View ViewModel

- Designed to separate the UI logic from the business logic. 
**Components**
1. Model: Represents data and business logic
2. View: Displays the daata and receives user interactions. 
3. ViewModel: Manages the data for the View and communicates with the model.

## Enabling ViewModel in Android

```
dependencies {
    val lifecycle_version = "2.8.1"
    implementation("android.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
}
```