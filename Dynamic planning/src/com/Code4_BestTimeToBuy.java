package com;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author jjzmi
 * @description 买股票的最佳时机，收益最大
 * @create 2021-03-20-9:31
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code4_BestTimeToBuy {

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit (int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        // write code here
        return profit;
    }

    /**
     * 两个循环，后一个循环永远在前一个循环前面
     * @param prices
     * @return
     */
    public static int maxProfit2 (int[] prices) {
        // write code here
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < length - 1; i ++) {
            for (int j = i + 1; j < length; j ++) {
                max = (prices[j] - prices[i] > max ? prices[j] - prices[i] : max);
            }
        }
        return max;
    }


    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int[] a = {1, 4, 2};
        System.out.println(maxProfit(a));
        System.out.println(maxProfit2(a));


    }

}
