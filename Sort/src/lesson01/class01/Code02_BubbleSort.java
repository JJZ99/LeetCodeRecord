package lesson01.class01;

import java.util.*;

/**
 * @author jjz
 * @project LeetCode
 * @description: 冒泡排序
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-02-9:59
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int [] arr){

        if (arr==null||arr.length<2){
            return;
        }
        for (int e = arr.length-1; e >0; e--) {
            for (int i = 0; i <e ; i++) {
                if (arr[i]>arr[i+1]){
                    swap(arr, i, i + 1);
                }
            }
        }
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Vector<String> d = new Vector<>();
        Enumeration<String> elements = d.elements();
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
    }



}
