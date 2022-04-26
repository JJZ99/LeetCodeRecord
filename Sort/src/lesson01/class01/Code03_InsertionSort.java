package lesson01.class01;

/**
 * @author jjz
 * @project LeetCode
 * @description: 插入排序
 *                  插入排序在排序过程中是局部有序，随着插入项的增多，有序部分的项的位置会发生改变，
 *                  而冒泡排序和选择排序每轮确定的项数的位置是永远不变的。在首轮，选择第二项作为插入项，
 *                  然后取出这一项放在一个变量中，和前一项比较而且小，则前一项后移到第二项的位置，
 *                  然后第二项也就是插入项放在前一项的位置，
 *                  第二轮选择第三项作为插入项然后取出和前一项也就是第二项比较如果小，
 *                  第二项后移到插入项，然后插入相在和第一项比较如果小，则第一项后移到第二项，
 *                  插入项放在第一项，以此类推。
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-02-10:06
 */
public class Code03_InsertionSort {
    public static void insertionSort(int [] arr){
        if (arr==null||arr.length<2){
            return;
        }
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i-1; j>=0&&arr[j]>arr[j+1] ; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
