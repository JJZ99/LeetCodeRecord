package dada;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jjzmi
 * @description 环形数组
 * @create 2021-03-27-23:19
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class CircularArray {
    public static int[][] solution(int len) {
        int[][] arr = new int[len][len];
        int index = 1, i = 0, j = 0;
        while (index <= len * len) {
            while (j < len && arr[i][j] == 0) {
                arr[i][j++] = index++;
            }
            j--;
            i++;
            while (i < len && arr[i][j] == 0) {
                arr[i++][j] = index++;
            }
            j--;
            i--;
            while (j >= 0 && arr[i][j] == 0) {
                arr[i][j--] = index++;
            }
            j++;
            i--;
            while (i >= 0 && arr[i][j] == 0) {
                arr[i--][j] = index++;
            }
            j++;
            i++;
        }

        return arr;

    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] answer = solution(length);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j]+",");
            }
            System.out.println();
        }
    }
}
