package com;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description  最小的k个数
 * 输入：arr = [3,1,2,1], k = 3
 * 输出：[1,2,1] 或者 [2,1,1]或
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @create 2021-03-27-22:25
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code_044_LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] array = Arrays.copyOf(arr,k);
        return array;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {



    }

}
