package algorithms.warmup

import kotlin.collections.*
import kotlin.io.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
 *
 * @Author: zhaojunjie
 * @E-mail: jjz.miss.3344@outlook.com
 * @Date: 2022-04-24-11:42
 * @Description: https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
 */

/*
 * Complete the 'staircase' function below.
 *
 * The function accepts INTEGER n as parameter.
 */
const val A = "#"
const val B = " "



fun staircase(n: Int): Unit {
    var count = n

    // Write your code here
    var list = arrayListOf<String>()
    while (count != 0) {
        list.add(B);
        count--
    }
    for (i in 0 until n) {
        list[n-i-1]=A
        list.print()
    }
}

private fun <E> java.util.ArrayList<E>.print() {
    forEach {
        print(it)
    }
   // println(this.toString())
    println()

}


fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    staircase(n)
}
