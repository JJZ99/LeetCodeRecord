package com;

/**
 * @author jjzmi
 * @description 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
 * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，
 * 请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，
 * @create 2021-03-18-22:50
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code03_YearEndBonus {

    /**
     * 纯递归，没有备忘录
     * @param array
     */
    public static void start(int[][] array) {
        dp(array,array.length,array[0].length);
    }
    public static int dp(int[][] array, int i, int j) {
        if (i == 0 && j == 0) {
            return array[0][0];
        }
        if (i==0) {
            return array[i][j] + array[i][j - 1];

        }
        if (j==0) {
            return  array[i - 1][j] + array[i][j];
        }
        return array[i][j] + Math.max(dp(array, i - 1, j), dp(array, i, j - 1));
    }

    private static int[][] memo;
    /**
     * 递归+备忘
     * @param array
     */
    public static void start2(int[][] array) {
        memo = new int[array.length][array[0].length];
        memo[0][0] = array[0][0];
        dp2(array,array.length-1,array[0].length-1);
    }
    public static int dp2(int[][] array, int i, int j) {
        if (i == 0 && j == 0) {
            return memo[0][0];
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        if (i==0) {
            memo[i][j] = array[i][j] + dp2(array, i, j - 1);
            return memo[i][j];
        }
        if (j==0) {
            memo[i][j] = dp2(array, i-1, j ) + array[i][j];
            return memo[i][j];
        }
        memo[i][j] = array[i][j] + Math.max(dp2(array, i - 1, j), dp2(array, i, j - 1));
        return memo[i][j];
    }


    private static int[][] memo2;
    /**
     * 正宗的动态规划 两个for + 备忘
     * @param array
     * @return
     */
    public static int dp3(int[][] array) {
        memo2 = new int[array.length][array[0].length];
        memo2[0][0] = array[0][0];
        int row = array.length;
        int col = array[0].length;
        for (int i = 1; i < row; i++) {
            memo2[0][i] = memo2[0][i - 1] + array[0][i];
            memo2[i][0] = memo2[i - 1][0] + array[i][0];
        }
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < col; j++) {
                memo2[i][j] = array[i][j] + Math.max(memo2[i - 1][j], memo2[i][j - 1]);
            }
        }
        return memo2[row-1][col-1];
    }




}
