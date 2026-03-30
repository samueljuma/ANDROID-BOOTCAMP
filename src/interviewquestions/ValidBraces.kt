package interviewquestions

// A function that takes  string of braces and checks whether
// all have opening and closing companions and that they should
// appear in the right positions i.e ({}), {}(), {({})}
fun validBraces(braces: String): Boolean{
    val stack = mutableListOf<Char>()

    for(brace in braces){
        when(brace) {
            '(', '{', '[' -> stack.add(brace)
            ')', ']', '}' -> {
                if(stack.isEmpty()) return false

                val last = stack.removeLast()

                if(
                    (brace == ')') && last != '(' ||
                    (brace == '}' && last != '{') ||
                    (brace == ']' && last != '[')
                ){
                    return false
                }
            }

        }
    }

    return stack.isEmpty()
}

fun validBraces1(braces: String): Boolean {
    val stack = mutableListOf<Char>()
    val pairs = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (brace in braces) {
        if (brace in pairs.values) {
            stack.add(brace)
        } else if (brace in pairs.keys) {
            if (stack.isEmpty() || stack.removeLast() != pairs[brace]) {
                return false
            }
        }
    }

    return stack.isEmpty()
}

fun main(){
    val braces = "{{{[({})]}}}"
    print(validBraces1(braces))
}