package lesson01.class01;

/**
 * @author jjz
 * @project LeetCode
 * @description: 选择排序
 *                  首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 *                  然后，再从剩余未排序元素中继续寻找最小（大）元素，
 *                  然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-02-9:58
 */
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j <arr.length ; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;

            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
