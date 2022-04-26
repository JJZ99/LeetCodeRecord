package Java_1;

import javax.sound.midi.Soundbank;

/**
 * @author jjzmi
 * @description 我们都知道: 1+2+3+.. + 49= 1225
 *               现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
 * @create 2021-04-17-20:39
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 加法变乘法 {
    public static void solution(){

        for (int i = 1; i < 47; i++) {
            for (int j = i + 2; j < 49; j++) {
                if (((j * (j + 1)) + (i * (i + 1))) - ((i) + (i + 1) + (j) + (j + 1)) == 790) {
                    System.out.println(i);
                }
            }
        }
    }
    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        solution();
    }
}
