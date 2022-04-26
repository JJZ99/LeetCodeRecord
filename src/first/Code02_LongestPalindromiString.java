package first;



/**
 * @author jjzmi
 * @description 最大回文字符串
 * @create 2021-03-19-14:38
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code02_LongestPalindromiString {

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        // 记录最长回文串
        String res = "";

        // 穷举以所有点（奇数一个点，偶数两个点）为中心的回文串
        for (int i = 1; i < s.length() - 1; i++) {
            String s1 = "";
            String s2 = "";
            // 当回文串是奇数时，由一个中心点向两边扩散
            s1 = palindrome(s, i, i);
            // 当回文串是偶数时，由中间的两个中心点向两边扩散
            s2 = palindrome(s, i, i + 1);

            // 三元运算符：判断为真时取冒号前面的值，为假时取冒号后面的值
            res = res.length() < s1.length() ?  s1:res ;
            res = res.length() < s2.length() ? s2: res ;
        }
        return res;
    }
    private static String palindrome(String s, int l, int r) {
        int len = s.length();
        //这里要先判断长度是否越界
        while (l >= 0 && r < len &&s.charAt(l) == s.charAt(r) ) {
            l--;
            r++;
        }
        return s.substring(++l, r);
    }

    /**
     * 优化的算法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        // 记录最长回文串

        int[] rang = new int[2];
        char[] chars = s.toCharArray();
        int low = 0;
        for (int i = 0; i < s.length() ; i++) {

            low = i;
            int high = low;
            while (high < (s.length()-1) && chars[low] == chars[high+1]) {
                ++high;
            }
            //这里是重点：已经找到了一段回文数，下一个可能存在的回文数一定在high之后
            i = high;
            while (low > 0 && high < chars.length - 1 && chars[low-1] == chars[high+1]) {
                --low;
                high++;
            }
            if (rang[1] - rang[0] < high - low) {
                rang[0] = low;
                rang[1] = high;
            }
        }
        return s.substring(rang[0], rang[1] + 1);
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        String s = "111222333";
        long startTime = System.currentTimeMillis();
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome(s));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }


}
