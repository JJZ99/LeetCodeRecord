package com.DailyCodingProblem;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description: 给定一个严格由字符'R'， 'G'和'B'组成的数组，分离数组的值，使所有的R排在前面，G排在后面，B排在最后。只能交换数组中的元素。
 *                在线性时间内就地完成。
 *                例如,考虑到array [' G ', ' B ', ' R ', ' R ', ' B ', ' R ', ' G '],
 *                它应该成为[‘R’,‘R’,‘R’,‘G’,‘G’,' B ', ' B ']。
 * @create 2021-03-12-12:36
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Problem_35_Hard {

    public final static char R = 'R';
    public final static char G = 'G';
    public final static char B = 'B';

    /**
     * 统计R G B出现的次数
     * @param array
     * @return 返回排序完后的数组
     */
    public static char[] solution(char[] array){
        int rCount = 0;
        int gCount = 0;
        int bCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==R){
                rCount++;
                continue;
            }
            if (array[i]==G){
                gCount++;
                continue;
            }
            if (array[i]==B){
                bCount++;
                continue;
            }
        }
        for (int i = 0; i < rCount; i++) { array[i] = R; }
        for (int i = 0; i < gCount; i++) { array[rCount+i] = G; }
        for (int i = 0 ; i < bCount; i++) { array[rCount + gCount+i] = B; }
        return array;
    }


    /**
     * 产生一个随机数组
     * @param maxlength
     * @return
     */
    public static char[] generateRandomArray(int maxlength) {
        int realLength = 0;
        while (realLength == 0){
            realLength = (int)( Math.random() * (maxlength+1));
        }
        if (realLength == 0) {
            return null;
        }
        char[] arr = new char[realLength];
        for (int i = 0; i < arr.length; i++) {
            int ran = (int) (Math.random() * 3 + 1);
            if (ran == 1) {
                arr[i]=R;
                continue;
            }
            if (ran == 2) {
                arr[i] = G;
                continue;
            }
            if (ran == 3) {
                arr[i] = B;
                continue;
            }
        }
        return arr;
    }

    public static boolean check(char[] arr, char[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[arr2.length - i-1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int maxLength = 500;
        int testTimes = 500000;

        System.out.println("开始测试---------");
        for (int i = 0; i < testTimes; i++) {
            System.out.println("第" + (i + 1) + "次");
            char[] chars = generateRandomArray(maxLength);
            char[] chars2 = chars.clone();
            chars = solution(chars);
            Arrays.sort(chars2);
            if (!check(chars, chars2)) {
                System.out.println("fuck fucking");
                System.out.println("chars:"+Arrays.toString(chars));
                System.out.println("chars:"+Arrays.toString(chars2));
                return;
            }
        }
        System.out.println("Nice!!!");
    }
}
