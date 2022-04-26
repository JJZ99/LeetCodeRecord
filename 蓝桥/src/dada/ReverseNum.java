package dada;

/**
 * @author jjzmi
 * @description 反转数字
 * @create 2021-03-20-10:21
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class ReverseNum {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public static int reverse (int x) {
        if (x < 0) {
            String s2 = "-";
            String s = String.valueOf(-x);
            for (int i = s.length() - 1; i >= 0; i--) {
                s2 += s.charAt(i);
            }
            return Integer.parseInt(s2);

        } else {
            String s2 = "";
            String s = String.valueOf(x);
            for (int i = s.length() - 1; i >= 0; i--) {
                s2 += s.charAt(i);
            }
            return Integer.parseInt(s2);
        }

    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int a = 1536;
        System.out.println(reverse(a));

    }
}
