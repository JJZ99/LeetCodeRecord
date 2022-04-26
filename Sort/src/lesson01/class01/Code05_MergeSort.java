package lesson01.class01;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description 归并排序
 * @create 2021-03-17-21:01
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code05_MergeSort {

    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R ) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr,M + 1 ,R );
        marge(arr, L, M, R);
    }

    public  static void marge(int[] arr, int L,int M, int R) {

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }

    }

    public static int[] generateRandomArr(int maxLength, int maxNum) {

        int len = (int) (Math.random() * (maxLength) + 1);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1) - Math.random() * (maxNum + 1));
        }
        return arr;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int maxLength = 1000;
        int testTimes = 50000;
        int maxNum = 200;
        System.out.println("测试开始---------");
        for (int i = 0; i < testTimes; i++) {
            int[] array = generateRandomArr(maxLength, maxNum);
            int[] array2 = Arrays.copyOf(array, array.length);
            mergeSort1(array);
            Arrays.sort(array2);
            if (!check(array, array2)) {
                System.out.println("出错啦 fucking !!!!，第"+(i+1)+"次");
                System.out.println(array.toString());
                System.out.println(array2.toString());
                return;
            }
        }
        System.out.println("Nice!!!!");

    }

    private static boolean check(int[] array, int[] array2) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

}
