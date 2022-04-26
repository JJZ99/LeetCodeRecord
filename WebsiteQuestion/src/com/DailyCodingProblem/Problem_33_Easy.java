package com.DailyCodingProblem;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description 计算一系列数字的运行中位数。也就是说，给定一个数字流，打印出到目前为止列表中每个新元素的中位数。
 * 回忆一下，偶数列表的中位数是两个中间数的平均值。
 * 例如，给定序列[2,1,5,7,2,0,5]，你的算法应该输出:
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 * @create 2021-03-11-23:54
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Problem_33_Easy {

    public static void solution(int[] arr) {
        if (arr.length >= 1) {
            System.out.println(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.println("----第"+(i+1)+"次----");
            int[] item = new int[i+1];
            System.arraycopy(arr,0,item,0,i+1);
            //int[] item = Arrays.copyOfRange(arr, 0,i+1);
            Arrays.sort(item);
            if (item.length % 2 == 0) {
                System.out.println(((float)item[item.length/2-1]+(float)item[item.length/2])/2);
            }else{
                System.out.println(item[item.length/2]);
            }
            System.out.println(Arrays.toString(item));
        }

    }

    /**
     * 产生一个随机数组,value的范围为[-maxValue,maxValue]
     * @param length
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int length, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)-Math.random() * (maxValue + 1));
        }
        return arr;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int length = 8;
        int maxValue = 20;
        int[] arr = generateRandomArray(length, maxValue);
        System.out.println(Arrays.toString(arr));
        solution(arr);




    }
}
