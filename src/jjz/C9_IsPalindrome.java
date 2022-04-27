package jjz;


/**
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-27-16:28
 * @description: 判断一个数字是否是回文数
 */
public class C9_IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int size = s.length();
        int n = size / 2;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(6 / 2);
    }
}
