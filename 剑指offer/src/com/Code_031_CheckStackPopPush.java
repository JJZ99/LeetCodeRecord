package com;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jjzmi
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *               例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 *               但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * @create 2021-03-29-23:31
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code_031_CheckStackPopPush {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque();
        int j = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};
        boolean ans = validateStackSequences(push, pop);
        System.out.println(ans);


    }
}
