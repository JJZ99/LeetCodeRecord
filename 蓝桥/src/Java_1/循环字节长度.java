package Java_1;

import java.util.Vector;

/**
 * @author jjzmi
 * @description 求两个整数做除法，有时会产生循环小数，求出这个循环小数的长度
 * @create 2021-04-17-16:40
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 循环字节长度 {

    public static int f(int n, int m) {
        n = n % m;
        Vector<Integer> v = new Vector<>();
        for (; ; ) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) {
                return 0;
            }
            if (v.indexOf(n) >= 0) {
                return v.size();
            }
        }
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        System.out.println(f(11,13));


    }
}
