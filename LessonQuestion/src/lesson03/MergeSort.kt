package lesson03

import lesson03.MergeSort.Companion.process

/**
 *
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-28-21:20
 * @description: 归并排序
 */
class MergeSort {
    companion object{
        /**
         * 递归方法
         */
        fun process(array: Array<Int>, L: Int, R: Int) {
            if (L == R) {
                return
            }
            var mid = L + ((R - L) shr 1) //shr 右移1位
            process(array, L, mid)
            process(array, mid + 1, R)
            merge(array, L, mid, R)
        }
        fun merge(arr: Array<Int>, l: Int, m: Int, r: Int) {
            val help = arrayOfNulls<Int>(r - l + 1)
            var i = 0
            var p1 = l
            var p2 = m + 1
            while (p1 <= m && p2 <= r) {
                help[i++] = if (arr[p1] <= arr[p2]) arr[p1++] else arr[p2++]
            }
            while (p1 <= m) {
                help[i++] = arr[p1++]
            }
            while (p2 <= r) {
                help[i++] = arr[p2++]
            }
            for (i in 0 until help.size){
                arr[i+l] = help[i]!!
            }
        }
    }
}

fun main() {
    //var array = arrayOf<Int>(2, 1, 0, 15)
    var array = arrayOf<Int>(5, 4, 1, 8, 0, 0, 15, 22, 3, 2, 999, 1, 1, 1, 5, 2)
    process(array, 0, array.size - 1)
    println(array.toString())
   // var array2 = arrayOf<Int>(2, 1, 0, 15)
    var array2 = arrayOf<Int>(5, 4, 1, 8, 0, 0, 15, 22, 3, 2, 999, 1, 1, 1, 5, 2)
    array2.sort()
    println(array2.toString())

}
