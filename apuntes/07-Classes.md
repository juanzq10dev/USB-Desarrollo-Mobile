# Classes

- Class defining is the same as Java. 
- Creating constructor is definir
```kotlin
class Person {/*...*/}  // Defining a class
class Person constructor(firstName: String){/*...*/} // Define a class and its constructor
class Person (firstName: String) // Define a class and its constructor
```

All code that runs inside an `init` block runs when the class is created. 
```kotlin
class InitOrderDemo(name: String) {
    val firstProperty = name

    init { println("First initializer block that prints ${firstProperty}") }

    val secondProperty = name.lenght
    init { println("First initializer block that prints ${secondProperty}" ) }
}
```
- The upper init block runs first.

### Constructor with default values
```kotlin
class InitOrderDemo(val name: String, val lastName: String, var isPerson=True) {

}
```
- This constructor constains constant values: `name`  `lastName`
- `isPerson` contains a default value True.
- You can create the `InitOrderDemo` without a explicit `isPerson` param
## Secondary constructors
The next class has two constructors.
```kotlin
class Person(val name: String) {
    
    val children MultableList<Person> = mutableListOf()

    constructor(name: String, parent:Person): this(name) {
        parent.children.add(this)
    }
}
```

# Abstract classes

```kotlin
abstract class Polygon {
    abstract fun draw()
}

class Rectangle: Polygon() {
    override fun draw{ }
}
```

# Data class 
- A simple class used to hold data / state and contains standard functionality. 
- A data class needs a constructor that receives arguments. 

```kotlin
data class User(val name: String, val age: Int)
```