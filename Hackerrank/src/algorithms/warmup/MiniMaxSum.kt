package algorithms.warmup

/**
 *
 * @Author: zhaojunjie
 * @E-mail: jjz.miss.3344@outlook.com
 * @Date: 2022-04-25-11:34
 * @Description: algorithms.warmup
 */
class MiniMaxSum {
}
/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    arr.sort()
    var addCount = arr.size - 1
    var result: Long = 0L


    for (i in 0 until addCount) {
        result += arr[i]
    }
    print(result)
    print(" ")
    result = 0L
    for (i in 1 until arr.size) {
        result += arr[i]
    }
    print(result)
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}
