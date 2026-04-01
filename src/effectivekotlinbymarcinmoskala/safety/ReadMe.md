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

### Platform type 
- a type that comes from another language and has unknown nullability.

## Inferred Types

`Important Note`
> “In Kotlin, classes and methods are final by default. 
> You must explicitly mark them as open to allow inheritance or overriding. 
> This improves safety and prevents unintended extension.”

| Keyword      | Meaning                  |
|--------------|--------------------------|
| `class`      | ❌ Cannot inherit         |
| `open class` | ✅ Can inherit            |
| `open fun`   | ✅ Can override           |
| `override`   | Required when overriding |

### Other key words
| Keyword     | Use                    |
|-------------|------------------------|
| `abstract`  | Must be inherited      |
| `sealed`    | Restricted inheritance |
| `interface` | Always open            |

> The general rule is that if we are not sure about the type, we should
specify it. It is important information and we should not hide it
Additionally for the sake of safety, in an external API, we should always specify
types. We cannot let them be changed by accident. Inferred types
can be too restrictive or can too easily change when our project
evolves