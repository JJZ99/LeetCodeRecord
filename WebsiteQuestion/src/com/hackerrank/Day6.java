package com.hackerrank;

import java.util.Scanner;

/**
 * @author jjz
 * @project LeetCode
 * @description: Given a string, , of length  that is indexed from  to ,
 * print its even-indexed and odd-indexed characters
 * as  space-separated strings on a single line
 * (see the Sample below for more detail).
 * Sample Input:
 * 2
 * Hacker
 * Rank
 *
 * Sample Output:
 * Hce akr
 * Rn ak
 *
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-15-18:06
 */
public class Day6 {

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        String [] array= scan.nextLine().split(" ");
        System.out.println(array);
        int a=scan.nextInt();


        while (a>0){
            String s=scan.next();

            for (int i = 0; i < s.length(); i+=2) {
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
            for (int i = 1; i <s.length() ; i+=2) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
            a--;
        }

    }
}
