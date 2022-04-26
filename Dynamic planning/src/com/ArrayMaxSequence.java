package com;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description 数组最大的连续子序列问题
 * @create 2021-03-30-16:13
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ArrayMaxSequence {

    public static int dp(int[] array) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            if (temp <= 0) {
                temp = 0;
            }
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 6, 7, -1, 4, 3};
        System.out.println(Arrays.toString(arr));
        int ans = dp(arr);
        System.out.println(ans);
    }
}
