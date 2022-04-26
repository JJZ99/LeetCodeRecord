package com.DailyCodingProblem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author jjz
 * @project LeetCode
 * @description: This problem was asked by Uber.
 *                Given an array of integers, return a new array
 *                such that each element at index i of the new array
 *                is the product of all the numbers in the original array
 *                except the one at i.
 *                For example, if our input was [1, 2, 3, 4, 5],
 *                the expected output would be [120, 60, 40, 30, 24].
 *                If our input was [3, 2, 1], the expected output
 *                would be [2, 3, 6].
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-07-22:05
 */
public class Day1 {
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int a=scanner.nextInt();
        int[] array = new int[a];
        System.out.print("请输入数据，空格隔开：");
        for (int i = 0; i <array.length ; i++) {
            a=scanner.nextInt();
            array[i]=a;
        }
        System.out.println("输入：");
        System.out.println(Arrays.toString(array));
        System.out.println("输出：");
        System.out.println(Arrays.toString(ExceptTheI(array)));



    }
    public static int[] ExceptTheI(int [] arr){
        int counter=0;
        int index=arr.length;
        int take=1;
        if (arr == null||arr.length==0||arr.length==1) {
            return null ;
        }

        if (arr.length==2){
            if (arr[1]==arr[0]){
                arr[0] = arr[0] ^ arr[1];
                arr[1] = arr[0] ^ arr[1];
                arr[0] = arr[0] ^ arr[1];
                return arr;
            }else {
                return  arr;
            }

        }
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==0){
                counter++;
                index=i;
            }
        }

        int[] newArr = new int[arr.length];
        if (counter==0){
            for (int i = 0; i < arr.length; i++) {
                take = take * arr[i];
            }
            for (int i = 0; i <arr.length ; i++) {
                newArr[i] = take / arr[i];
            }
        }else if(counter==1){
            for (int i = 0; i < arr.length; i++) {
                if (i!=index) {
                    take = take * arr[i];
                }
            }
            newArr[index] = take;
        }
        return newArr;
    }
}
