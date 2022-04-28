package jjz

import jjz.C463_IslandPerimeter.Companion.islandPerimeter

/**
 *
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-28-12:04
 * @description: jjz
 */
class C463_IslandPerimeter {
    companion object {
        fun islandPerimeter(grid: Array<IntArray>): Int {
            var answer = 0
            val n = grid.size
            val n1 = grid[0].size
            for (i in 0 until n) {
                for (j in 0 until n1){
                    if (grid[i][j]==1){
                        answer += help(grid, i, j)
                    }
                }
            }
            return answer
        }
        fun help(grid: Array<IntArray>, i: Int, j: Int): Int {
            var result = 0;
            if (j - 1 < 0 || grid[i][j-1] == 0) {

                ++result;
            }
            if (j + 1 >= grid[0].size || grid[i][j+1] == 0) {
                ++result;
            }
            if (i - 1 < 0 || grid[i - 1][j] == 0) {
                ++result;
            }
            if (i + 1 >= grid.size || grid[i+1][j] == 0) {
                ++result;
            }
            return result;
        }
    }
}

fun main() {
    val grid = arrayOf<IntArray>(intArrayOf(1, 0))
//    val grid = arrayOf<IntArray>(intArrayOf(0, 1, 0, 0),
//            intArrayOf(1, 1, 1, 0),
//            intArrayOf(0, 1, 0, 0),
//            intArrayOf(1, 1, 0, 0))
    println(islandPerimeter(grid))


}

