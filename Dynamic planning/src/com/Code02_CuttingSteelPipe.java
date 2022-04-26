package com;

/**
 * @author jjzmi
 * @description  切钢管问题
 * @create 2021-03-11-0:25
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code02_CuttingSteelPipe {
    /**
     * 钢管数组长度为length+1。对应长度的下边放着其价格
     *   arr[0] arr[1] arr[2] arr[3] arr[4] arr[5]  arr[钢管长度]
     *   0      1      2      4      6      7       人民币
     */
    private static int[] array;
    /**
     * 备忘数组，长度为length+1。对应长度的下标放着能买的最大价格
     *   memo[0] memo[1] memo[2] memo[3] memo[4] memo[5]  memo[钢管长度]
     *   ,      ,        ,       ,       ,       ,            maxMoney
     */
    private static int[] memo;

    /**
     * 计算该长度的钢管能买的最大价值
     * @param length 钢管长度
     * @return maxMoney
     */
    public static int dp(int length){
        if (length == 1) {
            return memo[1];
        }
        if (length > 1) {
            if (memo[length] != 0) {
                return memo[length];
            } else {
                memo[length] = array[length];
                for (int i = 1; i <= length / 2; i++) {
                    int item = dp(length - i) + dp(i);
                    if (item > memo[length]) {
                        memo[length] = item;
                    }
                }
                return memo[length];
            }
        }
        return 0;
    }

    /**
     * 计算该长度的钢管能买的最大价值
     * @param length 钢管长度
     * @return maxMoney
     */
    public static int dp2(int length){
        if (length == 1) {
            return memo[1];
        }
        if (length > 1) {
            if (memo[length] != 0) {
                return memo[length];
            } else {
                memo[length] = array[length];
                for (int i = 1; i < length; i++) {
                    int item = (array[i] + dp2(length - i));
                    // 更新备忘录
                    if (memo[length] < item) {
                        memo[length] = item;
                    }
                }
            }
            return memo[length];
        }
        return 0;
    }

    /**
     * 产生一个钢管数组的方法
     * @param length 长度
     * @return arr[]
     */
    public static int[] generateArray(int length){

        //等待填写

        return new int[length];
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        array = new int[]{0,5, 6, 7, 8};
        memo = new int[5];
        memo[1] = array[1];
        int ans = dp(4);
        int ans2 = dp2(4);
        System.out.println("最大价值:"+ans);
        System.out.println("最大价值2:"+ans2);
    }
}
