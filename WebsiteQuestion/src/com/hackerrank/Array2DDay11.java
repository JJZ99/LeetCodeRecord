package com.hackerrank;

/**
 * @author jjzmi
 * @description 打印出在一个二维正方形矩阵中，3x3区域内总和最大的值
 * @create 2021-02-19-10:51
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Array2DDay11 {
    public static void Solution(int[][] array){
        int max = 0, tem = 0;
        if (array.length<3||array[0].length<3) {
            System.out.println("输入格式错误");
        } else{
            for (int i = 0; i <array.length-2 ; i++) {
                for (int j = 0; j <array[i].length-2 ; j++) {
                    for (int k = 0; k <3 ; k++) {
                        tem += array[i][j + k] + array[i + 1][j + k] + array[i + 2][j + k];

                    }

                    max = tem > max ? tem : max;
                    tem = 0;
                }


            }
            System.out.println(max);

        }


    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}};
        System.out.println(arr.length);
        System.out.println(arr[1].length);

        Solution(arr);

    }
}
