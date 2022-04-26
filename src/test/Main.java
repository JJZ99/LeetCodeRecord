package test;

import java.util.Scanner;

/**
 * @author jjzmi
 * @description
 * @create 2021-04-18-16:59
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Main {

    public static int solution(int[] array) {
        int ans = 0;
        int temp = 0;
        int len = array.length;

        if (array.length == 1) {
            ans = array[0];
        }
        //以步长为1开始
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len;) {
                for (int k = 0; k < i; k++) {
                    if ((k + 1) % 2 == 1) {
                        temp += array[j+k];
                    } else {
                        temp -= array[j+k];
                    }
                }
                if (ans < temp) {
                    ans = temp;
                }
                temp = 0;
                j += i;
                if ((j + i) > len) {
                    break;
                }
            }

        }
        if(ans<=0){
            return 0;
        }else{
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));

    }

}
