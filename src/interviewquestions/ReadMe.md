### 1.What ara the Major differences between Java and Kotlin for Android development 
| Feature                  | Kotlin                                                                     | Java                                                            |
|--------------------------|----------------------------------------------------------------------------|-----------------------------------------------------------------|
| Conciseness              | Less boilerplate, more expressive (e.g., data classes, no getters/setters) | More verbose, requires more code                                |
| Null Safety              | Built-in null safety (`?`, `!!`, `?:`)                                     | No built-in null safety, prone to `NullPointerException`        |
| Interoperability         | Fully interoperable with Java                                              | Can interoperate with Kotlin but lacks Kotlin-specific features |
| Asynchronous Programming | Uses coroutines (lightweight, simpler)                                     | Uses threads, executors, and callbacks (more complex)           |
| Extension Functions      | Supported (add functions to existing classes)                              | Not supported                                                   |
| Data Classes             | Built-in `data class` auto-generates common methods                        | Must manually implement methods like `equals()`, `hashCode()`   |
| Smart Casting            | Automatic type casting after checks                                        | Requires explicit casting                                       |
| Default Arguments        | Supported in functions                                                     | Achieved via method overloading                                 |
| Functional Programming   | Strong support (lambdas, higher-order functions)                           | Limited support (lambdas from Java 8+)                          |
| Android Support          | Preferred language by Google                                               | Supported but not the primary recommendation                    |

