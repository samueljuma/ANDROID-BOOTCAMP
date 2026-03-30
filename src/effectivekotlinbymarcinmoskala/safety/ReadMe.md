## 1: Limit mutability
- `get()` - always reflects latest state
> Gets called each time i.e do on demand

### Strategies to limit mutability in Kotlin
- Read-only properties val
- Separation between mutable and read-only collections
- copy in data classes

> Smart Casting is impossible for immutable variables defined using getters
```kotlin
// i.e
    val fullName: String?
        get() = "$firstName  $lastName"
    if(fullName != null){
        print(fullName.length)
    }
```

### Avoid down-casting 
> Use approaches such as below
```kotlin
val list = listOf(1,2,3,4)
val mutableList = list.toMUtableList()
mutableList.add(5)
```

- `Copy` comes in handy whe you want to mutate an immutable variable.