# Fragments 

- A fragment cannot live alone, must live inside an activity.

## Fragment lifecycle

![alt text](res/fragment-view-lifecycle.png)

## Example
Fragments are usually inside a FragmentContainerView.

1. Create fragment
- For this example create a button, and add an id.

- On activity_main.xml create a FragmentContainerView with an id, the background color will be orange.

- Android studio create a Fragment using the right click menu > New > Fragment. The Frament name will be `FragmentOne`. 
    - From the kotlin class we remove all except the OnCreateView() method.

2. Load the fragment 
- Create a function that knows how to load a fragment.

```kotlin
func loadFragment(fragment: Fragment) {
    val fragmentManager = supportFragmentMAnager
    val fragmentTransaction = fragmentManager.beginTransaction() // In charge of managing fragmnet operations.
    fragmentTransaction.replace(R.id.fragmentContainerView, fragment)

    fragmentTransaction.commit()
}
```

- on button click listener add
```kotlin
button.setOnClickListener {
    loadFragment(FragmentOne())
}
```

So when the button is clicked the fragment appears (it has orange background).

