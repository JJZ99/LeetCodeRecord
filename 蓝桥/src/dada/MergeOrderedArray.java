package dada;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-31-20:24
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class MergeOrderedArray {

    /**
     * 产生一个随机数组
     * @param maxLength
     * @param maxNumber
     * @return
     */
    public static int[] generateRandomArray(int maxLength, int maxNumber) {
        int len = (int) (Math.random() * (maxLength) + 1);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNumber + 1) - Math.random() * (maxNumber + 1));
        }
        return arr;
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int i = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                ans[i] = arr1[p1];
                p1++;
            } else {
                ans[i] = arr2[p2];
                p2++;
            }
            ++i;
        }
        while (p1 < arr1.length) {
            ans[i] = arr1[p1];
            i++;
            p1++;
        }
        while (p2 < arr2.length) {
            ans[i] = arr2[p2];
            i++;
            p2++;
        }
        return ans;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int maxLength = 20;
        int maxNumber = 20;
        /*int[] arr1 = generateRandomArray(maxLength, maxNumber);
        int[] arr2 = generateRandomArray(maxLength, maxNumber);*/
        int[] arr1 = {-15, -12, -10, -6, -3, -2, 2, 2};
        int[] arr2 = {-15, -3, 3, 11};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] ans = mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(ans));


    }
}
