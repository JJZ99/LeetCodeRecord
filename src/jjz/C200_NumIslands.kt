package jjz

/**
 *
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-28-11:22
 * @description: 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/submissions/
 */
class C200_NumIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var counter = 0
        val n = grid.size
        val n1: Int = grid[0].size
        for (i in 0 until n) {
            for (j in 0 until n1) {
                if (grid[i][j] == '1') {
                    help2(grid, i, j)
                    counter++
                }
            }
        }
        return counter
    }

    fun help2(grid: Array<CharArray>, i: Int, j: Int) {
        if (grid[i][j] == '0' || i < 0 || j < 0 || i >= grid.size || j >= grid[0].size) {
            return
        }
        grid[i][j] = '0'
        help2(grid, i, j + 1)
        help2(grid, i, j - 1)
        help2(grid, i + 1, j)
        help2(grid, i - 1, j)
    }
}


