package com.DailyCodingProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jjz
 * @project LeetCode
 * @description: Given an array of integers, find the first missing positive
 *              integer in linear time and constant space. In other words, find
 *              the lowest positive integer that does not exist in the array.
 *              The array can contain duplicates and negative numbers as well.
 *              For example, the input [3, 4, -1, 1] should give 2.
 *              The input [1, 2, 0] should give 3.
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-09-9:48
 */
public class Day4 {

    /**
     *
     * @param arr
     * @return
     */
    public static int find(int [] arr){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<0){
                return i;
            }
        }
        return arr.length;
    }
    /**
     * 产生一个随机数组
     * @param maxSize 数组的最大大小
     * @param maxValue-minvalue 最大的值
     * @param minValue 最小的值
     * @return 新数组
     */
    public static int[] generateTandomArray(int maxSize, int maxValue ,int minValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i <arr.length ; i++) {
            //产生[minvalue,maxValue-minvalue]的随机值
            arr[i] = (int) ((maxValue+1) * Math.random() + minValue);
        }
        return arr;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int maxSize=50;
        int maxValue=40;
        int minValue=-10;
        int [] arr=generateTandomArray(maxSize,maxValue,minValue);
        System.out.println(Arrays.toString(arr));
        System.out.println(find(arr));

    }
}
