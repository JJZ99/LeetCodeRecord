package Java_1;

/**
 * @author jjzmi
 * @description 小明被劫持到X赌城，被迫与其他3人玩牌。
 * 一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
 * 这时，小明脑子里突然冒出一个问题：
 * 如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 * @create 2021-04-17-22:19
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class 牌型整数 {
    static int sum = 0;
    static int count = 0;

    /**
     * sum是取牌的数量，n是取得牌的数字是几。n的范围是0~12
     * @param n
     */
    public static void f(int n) {
        //sum>13表示牌取多了。n>13表示一共13种牌，不可能取到第14种
        if (sum > 13 || n > 13) {
            return;
        }
        //只有当取牌的数量达到13张的时候，表示这次可行
        if (sum == 13) {
            count++;
            return;
        }
        //从0到4，一共五种取法，因为存在可以一张不取的情况
        for (int i = 0; i < 5; i++) {
            sum += i;
            f(n + 1);
            //回溯回去
            sum -= i;
        }
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        f(0);
        System.out.println(count);


    }

}
