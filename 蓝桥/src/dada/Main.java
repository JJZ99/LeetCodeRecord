package dada;

import java.util.Scanner;

/**
 * @author jjzmi
 * @description 摇摆数组
 * @create 2021-03-27-10:31
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            int a = sc.nextInt();
            arr[i] = a;
        }
        System.out.println(solution(arr));
    }
    public static int solution(int[] array) {
        int flag = -1;
        int max = 0;
        int counter = 0;
        if (array == null || array.length < 4) {
            return counter;
        }
        int times = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) {
                if ((times + 1) > 2 ) {
                    if (flag == 1) {
                        times = 0;
                        counter = Math.max(max, counter);
                    } else {
                        times = 1;
                        counter++;
                    }
                } else {
                    if (flag == 1) {
                        times += 1;
                        counter++;
                    } else {
                        times = 1;
                        counter++;
                    }
                }
                flag = 1;
            }
            if (array[i] < array[i + 1]) {
                if ((times + 1)> 2) {
                    if (flag == 0) {
                        times = 0;
                        counter = Math.max(max, counter);
                    } else {
                        times = 1;
                        counter++;
                    }
                } else {
                    if (flag == 1) {
                        times = 1;
                        counter++;
                    } else {
                        times += 1;
                        counter++;
                    }
                }
                flag = 0;
            }
            if (array[i] == array[i + 1]) {
                flag = -1;
                if (counter >= 4) {
                    counter = Math.max(max, counter);
                } else {
                    counter = 0;
                }
            }
        }
        ++counter;

        return counter < 4 ? 0 : counter;
    }
}
