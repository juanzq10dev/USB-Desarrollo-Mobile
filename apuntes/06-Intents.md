# Intents

Messaging object used to request any action from another app component.

## Implicit Intents
Components cannot be specified.

Example: Opening browser. 

Add this code inside a button listener.

```kotlin
var intent = new Intent(Intent.ACTION_VIEW)
intent.setData(Uri.parse("http//www.youtube.com"))
startActivity(intent)
```
When clicking the button the app will open a Browser and will go open YouTube.


## Explicit Intents
The targeted component is specified, so only the specified target will be invoked.

Example: Calling second activity

Create a second activity, and put this code on the button event on MainActivity.
```kotlin
var intent = Intent(this, SecondActivity::class.java)
startActivity(intent)
```
When clicking on the button the app will go the secondActivity.

### Passing params
On MainActivity do: 
```kotlin
var intent = Intent(this.SecondActivity::class.java)
intent.putExtra(key, value)
startActivity(intent)
```
and on SecondActivity do: 
```kotlin
onCreate() {
    ...
    intent.getStringExtra(key)
    ...
}
```