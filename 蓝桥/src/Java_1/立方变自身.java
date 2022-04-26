package Java_1;

/**
 * @author jjzmi
 * @description 某个数字的立方，按位累加仍然等于自身
 * @create 2021-04-17-15:35
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 立方变自身 {

    public static boolean help(int n){
        String s = "" + n * n * n;
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }



    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int max = 100;
        int count = 0;
        for (int i = 1; i <= max; i++) {
            System.out.println("第"+i+"次");
            if (help(i)) {
                ++count;
            }
        }
        System.out.println(count);
    }

}
