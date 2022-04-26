package com;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jjzmi
 * @description 给定不同面额的硬币 coins 和一个总金额 amount。
 *              编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 *              如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 链接：https://leetcode-cn.com/problems/coin-change
 * @create 2021-03-31-21:53
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
        //初始化dp表，最大值目标最大值 + 1,相当于无穷大
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //初始化dp表里面数据全部为max
        Arrays.fill(dp, max);
        //已知目标金额为0的时候，需要0个硬币
        dp[0] = 0;
        //遍历1到amount需要多少硬币
        for(int i = 1; i <= amount; i++) {
            //遍历所有硬币
            for(int coin : coins) {
                if(i - coin < 0) {
                    continue;
                }
                //子问题dp[i-coin]加1枚硬币就是当前硬币的需要个数
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        //如果目标金额的一直没有答案返回-1
        return dp[amount] == max ? -1 : dp[amount];
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int[] coin = {1,2,5,10};
        System.out.println(coinChange(coin, 20));
    }

}
