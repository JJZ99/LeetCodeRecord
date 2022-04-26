package dada;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * @author jjzmi
 * @description 最长有效括号 LeetCode32
 * @create 2021-03-30-17:55
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class LongestValidParenthesis {

    /**
     * 有几对括号
     * @param s "()(()"
     * @return
     */
    public static int solution(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }



    /**
     * 在此方法中，我们利用两个计数器 left 和 right 。首先，我们从左到右遍历字符串，
     * 对于遇到的每个 ‘(’‘(’，我们增加 left 计数器，对于遇到的每个 ‘)’‘)’ ，
     * 我们增加 right 计数器。每当 left 计数器与 right 计数器相等时，
     * 我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。当 right 计数器比 left 计数器大时，
     * 我们将 left 和 right 计数器同时变回 00。
     * 来回遍历两遍求最大
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }



    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        //System.out.println(solution("()(()"));
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("dadsadas");
        }).start();
        System.out.println("negin");


    }


}
