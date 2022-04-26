package com.DailyCodingProblem;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author jjz
 * @project LeetCode
 * @description: 数组合并问题
 *                 return a new sorted merged list from K sorted lists,
 *                 each with size N
 *                  For example, if we had [[10, 15, 30], [12, 15, 20], [17, 20, 32]],
 *                  the result should be [10, 12, 15, 15, 17, 20, 20, 30, 32]
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-08-22:20
 */
public class Day3 {
    /**
     * 这是一个main方法，是程序的入口
     * 将数组中的元素加入list，然后利用Collections.sort排序
     * 也可以用list.sort方法手写比较器
     */
    public static void main(String[] args) {
        Integer [][] arr=new Integer[4][4];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                //产生[0,50]随机数
                arr[i][j]=(int)(Math.random()*50+1);
                list.add(arr[i][j]);
            }
        }
        System.out.println(Arrays.toString(arr[1]));

        //Collections.sort(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });
        System.out.println(list);
        Integer[] arr2 = new Integer[list.size()];
        list.toArray(arr2);
        System.out.println(Arrays.toString(arr2));

        List a= new ArrayList();

    }
}
