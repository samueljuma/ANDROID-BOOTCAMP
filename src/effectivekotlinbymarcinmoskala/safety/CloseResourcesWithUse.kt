package effectivekotlinbymarcinmoskala.safety

import java.io.BufferedReader
import java.io.FileReader

/**
 * There are resources that cannot be closed automatically, and we
 * need to invoke the close method once we do not need them
 * anymore. The Java standard library, that we use in Kotlin/JVM,
 * contains a lot of these resources, such as:
 * • InputStream and OutputStream,
 * • java.sql.Connection,
 * • java.io.Reader (FileReader, BufferedReader, CSSParser),
 * • java.new.Socket and java.util.Scanner.
 */

/**
 * Operate on objects implementing [Closeable] or [AutoCloseable]
 * using [use]. It is a safe and easy option. When you need to operate
 * on a file, consider useLines that produces a sequence to iterate
 * over the next lines.
 */

fun countCharactersInFile(path: String): Int{
    val reader = BufferedReader(FileReader(path))

    try {
        return reader.lineSequence().sumOf { it.length }
    }finally {
        reader.close()
    }


}

//Cleaner Version
fun countCharactersInFileP(path: String): Int{
    val reader = BufferedReader(FileReader(path))
    reader.use { reader ->
        return reader.lineSequence().sumOf { it.length }
    }

}