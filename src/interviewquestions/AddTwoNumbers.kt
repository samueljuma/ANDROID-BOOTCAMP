package interviewquestions

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1 ⬇
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2: ⬇
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3: ⬇
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
// 1 -> 2 -> 3 -> null

class ListNode(var value: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return buildString {
            var current: ListNode? = this@ListNode
            append("[")
            while (current != null) {
                append(current.value)
                current = current.next
                if (current != null) append(",")
            }
            append("]")
        }
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2

    val dummyNode = ListNode(0)
    var current = dummyNode
    var carry = 0

    while(p1 !=null || p2 != null || carry !=0){
        var x = p1?.value ?: 0
        var y = p2?.value ?: 0

        val sum = x + y + carry

        carry = sum / 10
        val digit = sum % 10

        current.next = ListNode(digit)
        current = current.next!!

        p1 = p1?.next
        p2 = p2?.next
    }

    return dummyNode.next
}

fun buildListNode(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var current = dummy

    for (v in values) {
        current.next = ListNode(v)
        current = current.next!!
    }

    return dummy.next
}

fun main(){

    val l1 = buildListNode(9,9,9,9,9,9,9)
    val l2 = buildListNode(9,9,9,9)

    val result = addTwoNumbers(l1, l2)
    println(result.toString())

}


