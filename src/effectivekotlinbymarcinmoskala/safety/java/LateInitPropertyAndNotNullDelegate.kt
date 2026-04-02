package effectivekotlinbymarcinmoskala.safety.java

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

class User(val name: String)

/**
 * It is not uncommon in projects to have properties that cannot be
 * initialized during class creation, but that will surely be initialized
 * before the first use. A typical example is when the property is set-up
 * in a function called before all others, like in @BeforeEach in JUnit 5:
 *
 * One case in which lateinit cannot be used is when we need
 * to initialize a property with a type that, on JVM, associates to
 * a primitive, like Int, Long, Double or Boolean. For such cases
 * we have to use Delegates.notNull which is slightly slower, but
 * supports those types:
 */
class RepositoryTest{

    private lateinit var user: User
    private var randomAge by Delegates.notNull<Int>()

    @BeforeEach
    fun doThis(){
        user = User("Sammy Juma")
        randomAge = 18
    }

    @Test
    fun  `is name Sammy Jama`(){
        assert(user.name == "Sammy Juma")
    }

    @Test
    fun `is age 18+`(){
        assert(randomAge >= 18 )
    }

    @AfterEach
    fun cleanTests(){
        user = User("John Doe")
    }
}

