## Avoid returning or operating on Unit?
> Prefer Boolean instead 

## Specify the variable type when it is not clear

> Do not change scope receiver just because you can. It might be
confusing to have too many receivers all giving us methods we can
use. Explicit argument or reference is generally better. When we
do change receiver, using explicit receivers improves readability
because it clarifies where does the function come from. We can
even use a label when there are many receivers to clarify from
which one the function comes from. If you want to force using
explicit receivers from the outer scope, you can use DslMarker
meta-annotation.

## Properties should represent stat not behavior 
> Because properties are essentially functions, 
we can make extension properties as well:

```kotlin
val Context.preferences: SharedPreferences
    get() = PreferenceManager
        .getDefaultSharedPreferences(this)

val Context.inflater: LayoutInflater
get() = PreferencesManager
    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
```

> Properties should not be used to represent algorithmic 
> behaviour like in the example below:

```kotlin
val Tree<Int>.sum: Int
    get() = when(this){
        is Leaf -> value
        is Node -> left.sum + right.sum
    }
```

`note`
>calculating the sum of elements requires iterating over all of the 
elements (this is behavior, not state) and has linear complexity. 
Therefore it should not be a property, and is defined in
the standard library as a function.

## Respect Coding Conventions 
- Use standard conventions 
- Ktlint can be leveraged for this as well. 