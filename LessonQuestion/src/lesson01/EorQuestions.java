package lesson01;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

/**
 * @author jjz
 * @project LeetCode
 * @description: com
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-02-18:57
 */
public class EorQuestions {
    /**
     * arr中只有一种数出现了奇数次次，打印出这个数
     * @param arr
     */
    public  static void printOddTimesNum1(int [] arr){
        int eor = 0;
        for (int i = 0; i <arr.length ; i++) eor ^= arr[i];
        System.out.println(eor);
    }

    /**
     * arr中有2种数出现了奇数次，其他数都出现了偶数次，打印出这两个数
     * @param arr
     */
    public  static void printOddTimesNum2(int [] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor^onlyOne));
    }

    /**
     * 获取整数 二进制中1的个数
     * @param N 整数
     * @return 返回count
     */
    public static int bit1counts(int N){
        int count = 0;

        while (N!=0){
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }
        return count;
    }

    /**
     * 返回一个整数二进制中 最右侧1的位置
     * @param N 整数
     * @return index(0......)
     */
    public static int bit1RightPosition(int N){
        int pos = -1;
        int a = N & ((~N) + 1);
        //int a = N & (-N);
        pos = (int) (Math.log(a) / Math.log(2));
        return pos;

    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        System.out.println(bit1counts(15));
        System.out.println(bit1RightPosition(2));
        int[] array = new int[]{1, 2, 3, 2, 3, 4, 5, 4, 5, 6};
        printOddTimesNum2(array);
        byte a = -128;
        System.out.println(a);



    }

}
