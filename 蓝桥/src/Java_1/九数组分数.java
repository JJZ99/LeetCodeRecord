package Java_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jjzmi
 * @description
 * @create 2021-04-17-19:10
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 九数组分数 {
    final static int S = 3;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void test(int[] x){
        int a = x[0] * 1000 + x[1] * 100 + x[2] * 10 + x[3];
        int b = x[4] * 10000 + x[5] * 1000 + x[6] * 100 + x[7] * 10 + x[8];
        if (a * S  == b) {
            if (!map.containsKey(a))
            map.put(a, b);

        }
    }
    public static void f(int[] x,int k){
        if (k >= x.length) {
            test(x);
            return;
        }
        for (int i = 0; i < x.length; i++) {
            { int t = x[k];
            x[k] = x[i];
            x[i] = t;
            }
            f(x, k + 1);
            { int t = x[k];
                x[k] = x[i];
                x[i] = t;
            }
        }
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(x, 0);
        Set<Integer> set = map.keySet();
        for (Integer a : set) {
            System.out.println(a + " " + map.get(a));
        }
    }
}
