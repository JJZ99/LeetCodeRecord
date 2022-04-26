package lesson01.class01;

import java.util.Arrays;

/**
 * @author jjz
 * @project LeetCode
 * @description: 测试类
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-02-10:47
 */
public class Test {
    /**
     * 这是一个main方法，是程序的入口
     * for test
     */
    public static void main(String[] args) {
        //测试五十万次
        int testTime = 500000;
        //数组最大长度
        int maxSize = 100;
        //最大数值
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0;i<testTime;i++){
            int[] arr1 = generateTandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            printArray(arr1);
            printArray(arr2);
            Code01_SelectionSort.selectionSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Woc CNM !!!");

        int[] arr = generateTandomArray(maxSize, maxValue);
        printArray(arr);
        Code01_SelectionSort.selectionSort(arr);
        printArray(arr);
    }

    /**
     * 打印
     * @param arr 打印的数组
     */
    public static void printArray(int[] arr) {

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 拷贝数组
     * @param arr1
     * @return 新的数组
     */
    public static int[] copyArray(int[] arr1) {
        if (arr1 == null) {
            return null;
        }
        int[] res = new int[arr1.length];
        for (int i = 0; i <arr1.length ; i++) {
            res[i] = arr1[i];
        }
        return res;
    }

    /**
     * 产生一个随机数组
     * @param maxSize 数组的最大大小
     * @param maxValue 最大的值
     * @return
     */
    public static int[] generateTandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue) * Math.random());
        }
        return arr;
    }

    /**
     * 比较两个数组是否相等
     * @param arr1 数组一
     * @param arr2 数组二
     * @return 相等 true 不相等 false
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {

        if ((arr1==null&&arr2==null)||arr1.length==0&&arr2.length==0) {
            return true;
        }

        if ((arr1==null&&arr2!= null)||arr1!=null&&arr2== null) {
            return false;
        }
        if (arr1.length!=arr2.length) {
            return false;
        }
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
