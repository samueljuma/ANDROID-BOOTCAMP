package interviewquestions

// BruteForce
fun twoSum(numbers: IntArray, target: Int): IntArray{
    numbers.forEachIndexed { index, num ->
        for(j in index +1..<numbers.size){
            if(numbers[index]+numbers[j] == target) return intArrayOf(index,j)
        }
    }
    return intArrayOf()
}

// 0(N)
fun twoSumOptimized(numbers: IntArray, target: Int): IntArray{
    val map = mutableMapOf<Int, Int>()
    // Create a Map that holds the values found
    numbers.forEachIndexed { index, num ->
        val complement = target - num
        if(map.containsKey(complement)){
            return intArrayOf(map[complement]!!, index)
        }
        map[num] = index
    }
    // Check if the complement exists in the map, if yes return the result
    return intArrayOf()
}

fun main(){
    val numbers = intArrayOf(1, 4, 3, 2, 9, 6)
    val target = 8
    println(twoSumOptimized(numbers, target).contentToString())
}

