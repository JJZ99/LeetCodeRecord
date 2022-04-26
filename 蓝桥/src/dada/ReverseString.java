package dada;


/**
 * @author jjzmi
 * @description 反转字符串
 * @create 2021-03-18-18:05
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ReverseString {
    final static char[] CHARS = {'a','b','c','d','e','f','g','h','i','j','k','l',
            'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public static String solve (String str) {
        char[] array = str.toCharArray();

        int begin = 0;
        int end = str.length() - 1;

        while (begin < end) {
            array[begin] = (char) (array[begin] ^ array[end]);
            array[end] = (char) (array[end] ^ array[begin]);
            array[begin] = (char) (array[end] ^ array[begin]);
            begin++;
            end--;
        }
        return new String(array);
    }

    public static String generateString(int maxLength) {
        int length = (int) (Math.random() * maxLength + 1);
        String str = "";
        for (int i = 0; i < length; i++) {
            int ran = (int) (Math.random() * 26);
            str = CHARS[ran] + str;
        }
        return str;
    }

    public static boolean check(String s1, String s2) {
        int length = s2.length() - 1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int maxLength = 1000;
        int testTime = 20000;

        for (int i = 0; i < testTime; i++) {
            String s = generateString(maxLength);
            String s2 = s + "";
            s = solve(s);
            if (!check(s, s2)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("Nice");
    }
}
