package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author jjz
 * @project LeetCode
 * @description: 爬楼梯问题 最多一步两个台阶 最少一个
 * There exists a staircase with N steps,
 * and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways
 * you can climb the staircase. The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * •	1, 1, 1, 1
 * •	2, 1, 1
 * •	1, 2, 1
 * •	1, 1, 2
 * •	2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time,
 * you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-17-21:23
 */
public class Code01_ClimbingStairsDay12 {
    /**
     * 这种是递归方法：显然如果只有一个台阶那么有1 如果有两个台阶那么就要2 way
     * f（n）=f（n-1）+f（n-2） 效率低
     * @param N 台阶数
     * @return ways
     */
    public static int Solution(int N) {

        if(N==1) {
            return 1;
        } else if (N==2) {
            return 2;
        } else {
            return Solution(N-1)+Solution(N-2);
        }
    }

    /**
     * 递归+缓冲数组保存数据 用数组Array存储已经计算过得数据
     * @param N
     * @return
     */
    public static Integer Solution2(int N,Integer[] arr) {
        if(N==1) {
            return 1;
        } else if (N==2) {
            return 2;
        } else {
            if (arr[N]>0) {
                return arr[N];
            }
            arr[N] = Solution2(N - 1, arr) + Solution2(N - 2, arr);
            return arr[N];
        }
    }

    /**
     * 循环 自底向上
     * @param N
     * @return
     */
    public static Integer Solution3(int N) {
        if(N==1) {
            return 1;
        } else if (N==2) {
            return 2;
        }
        int[] arr = new int[N + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        for (int i = 1; i <=10 ; i++) {
            System.out.println(Solution(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入台阶数：");
        int n = scanner.nextInt();
        //最多递归n层 记录n次 即每次都是1步
        Integer[] array = new Integer[n + 1];
        //因为是包装类 所以要new对象
        for (int i = 0; i <array.length ; i++) {
            array[i]= new Integer(0);
        }
        System.out.println(Solution2(n,array));
        System.out.println(Solution3(n));
        System.out.println(Integer.MAX_VALUE);


        scanner.close();

       // System.out.println(Solution(5));
    }
}
