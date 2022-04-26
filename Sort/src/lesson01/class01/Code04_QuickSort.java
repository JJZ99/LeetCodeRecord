package lesson01.class01;

import sun.security.util.Length;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author jjzmi
 * @description  快速排序
 * @create 2021-03-17-13:49
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code04_QuickSort {


    /**
     16  * 快排核心算法，递归实现
     17  * @param array
     18  * @param left
     19  * @param right
     20  */
    public static void quickSort(int[] array, int left, int right) {
         if(left > right) {
                 return;
             }
         // base中存放基准数
         int base = array[left];
         int i = left, j = right;
         while(i != j) {
             // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
             while(array[j] >= base && i < j) {
                 j--;
             }

             // 再从左往右边找，直到找到比base值大的数
             while(array[i] <= base && i < j) {
                 i++;
             }

             // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
             if(i < j) {
                 int tmp = array[i];
                 array[i] = array[j];
                 array[j] = tmp;
             }
         }
         // 将基准数放到中间的位置（基准数归位）
         array[left] = array[i];
         array[i] = base;

         // 递归，继续向基准的左右两边执行和上面同样的操作
         // i的索引处为上面已确定好的基准值的位置，无需再处理
         quickSort(array, left, i - 1);
         quickSort(array, i + 1, right);

    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int[] arr = new int[]{
                1, 6, 4, 2, 5, 3};
        int[] arr2 = new int[]{
                1, 6, 4, 2, 5, 3};

        Arrays.sort(arr);
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
}
