package Java_1;

import java.util.Arrays;

/**
 * @author jjzmi
 * @description
 * @create 2021-04-11-16:47
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 分机号 {
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution(){
        int num = 0;
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i > j && j > k) {
                        ++num;
                    }
                }
            }
        }
        return num;
    }
}
