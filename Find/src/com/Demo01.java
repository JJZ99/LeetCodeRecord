package com;

/**
 * @author jjz
 * @project LeetCode
 * @description: com
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-04-22:41
 */
public class Demo01 {
    /**
     * 在一个有序数组中，找某个数是否存在
     * @param sortedArr 有序数组
     * @param num 要查找的数
     * @return exist true unexist false
     */
    public static boolean exist(int[] sortedArr , int num){
        if (sortedArr==null||sortedArr.length==0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid]==num){
                return true;
            }else if (sortedArr[mid]>num){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;

    }


    /**
     * 在arr上，找满足>=value的最左位置
     * @param arr
     * @param value
     * @return index
     */
    public static int nearestIndex(int [] arr,int value){
        int L=0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid]>=mid){
                index = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return index;
    }

    /**
     * 返回一个局部最小值
     * 局部最小值：这个数小于左边和右边的数
     * @param arr
     * @return index
     */
    public static int getLessIndex(int[] arr){
        if (arr==null||arr.length==0) {
            return -1;
        }
        if (arr.length==1||arr[0]<arr[1]) {
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left<right){
            mid = (left + right) / 2;
            if(arr[mid]>arr[mid-1]){
                right = mid - 1;
            }else if (arr[mid]>arr[mid+1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }

}



