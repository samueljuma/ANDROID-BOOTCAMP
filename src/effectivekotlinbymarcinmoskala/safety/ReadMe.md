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

`note`
> The general rule is that if we are not sure about the type, we should
specify it. It is important information and we should not hide it
Additionally for the sake of safety, in an external API, we should always specify
types. We cannot let them be changed by accident. Inferred types
can be too restrictive or can too easily change when our project
evolves

`note`
>Always Prefer standard errors to custom ones

`note`
>We should prefer returning null or Failure when an error is expected, 
and throwing an exception when an error is not expected

> Handling all possibilities in a correct way - like here
not using printer when it is null - is an implementation of 
defensive programming. `Defensive programming` is a 
blanket term for various practices increasing
code stability once the code is in production, often
by defending against the currently impossible. It is
the best way when there is a correct way to handle
all possible situations. It wouldn’t be correct if we
would expect that printer is not null and should be
used. In such a case it would be impossible to handle
such a situation safely, and we should instead use
a technique called `offensive programming`. The idea
behind offensive programming is that in case of an
unexpected situation we complain about it loudly to
inform the developer who led to such situation, and to
force him or her to correct it. A direct implementation
of this idea is require, check and assert presented
in Item 5: Specify your expectations on arguments and
state. It is important to understand that even though
those two modes seem like being in conflict, they are
not at all. They are more like yin and yang. Those are
different modes both needed in our programs for the
sake of safety, and we need to understand them both
and use them appropriately.

`note`
> Operate on objects implementing Closeable or AutoCloseable
using `use`. It is a safe and easy option. When you need to operate
on a file, consider useLines that produces a sequence to iterate
over the next lines.