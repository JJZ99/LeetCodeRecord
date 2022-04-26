package test;

import sun.text.resources.cldr.ii.FormatData_ii;

import java.util.Arrays;
import java.util.List;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-18-8:38
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Test {

    public int[] MySort (int[] arr) {
        // write code here
        if(arr==null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        process(arr, 0, arr.length - 1);
        return arr;
    }

    public static void process(int[] arr , int L,int R) {
        if (L == R) {
            return;
        }


        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);


    }

    public static void merge(int[] arr, int L, int M, int R) {

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i <R - L + 1 ; i++) {
            arr[L + i] = help[i];
        }

    }


    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int[] addd = {1,2,3};

        String string = "0,1,2,3,4,5";

        String[] arr = string.split(",");
        List<String> list = Arrays.asList(arr);

        System.out.println(list);

        System.out.println(Arrays.toString(arr));
    }
}
