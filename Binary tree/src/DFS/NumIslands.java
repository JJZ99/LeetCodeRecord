package DFS;

/**
 * @author jjzmi
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *              岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *              此外，你可以假设该网格的四条边均被水包围
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * @create 2021-03-25-13:53
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    help(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;

    }

    public static void help(char[][] grid,int i,int j) {
        if (   i < 0 || j < 0 || i >= grid.length  || j >=grid[0].length || grid[i][j] == '0') {

            return;
        }
        grid[i][j] = '0';
        help(grid, i, 1+j);
        help(grid, 1+i, j);
        help(grid, i, j-1);
        help(grid, i-1, j);
    }


}
