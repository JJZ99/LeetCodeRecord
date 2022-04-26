package first;



/**
 * @author jjzmi
 * @description 回文数字
 * @create 2021-03-19-14:05
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code01_PalindromicNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s1 = String.valueOf(x);
        int times = s1.length() / 2;
        int length = s1.length()-1;
        for (int i = 0; i < times; i++) {
            if (s1.charAt(i) != s1.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int a = 222555222;
        if (!isPalindrome(a)) {
            System.out.println("Fuck fucking!!!");
        } else {
            System.out.println("Nice!!!");
        }
    }



}
