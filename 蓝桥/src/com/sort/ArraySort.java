package com.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-04-22:59
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ArraySort {

    public static int[] generateRandomArr(int maxlength,int maxNum){
        int length = (int) (Math.random() * maxlength + 1);
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum +1) - Math.random() * (maxNum +1));
        }
        return arr;
    }
    public  static int[] mySort(int[] arr){
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-1-i;j++) {
                if(arr[j]>arr[j+1]) {
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int maxlength = 1000;
        int maxNum = 10000;
        int testTime = 10000;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArr(maxlength, maxNum);
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = mySort(arr);
            Arrays.sort(arr2);
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(arr2));
            if (!check(arr, arr2)) {
                System.out.println("错啦！！！fuck fucking！！！");
                return;

            }
        }
        System.out.println("nice!!!");

    }
}
