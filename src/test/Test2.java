package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jjzmi
 * @description
 * @create 2021-04-18-17:57
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Test2 {
    static long[][] logs = {{200, 600}, {500, 800}, {900, 1500}};
    static long[] tss = {250,550,1000};


    public static int[][] search_log (long[][] logs, long[] tss) {
        List<Integer> list = new ArrayList<>();

        int[][] ans = new int[tss.length][];
        for (int i = 0; i < tss.length; i++) {
            for (int j = 0; j < logs.length; j++) {
                if ( tss[i] < logs[j][1] && tss[i] > logs[j][0] ) {
                    list.add(j);
                }
            }
            if (!list.isEmpty()) {
                ans[i] = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    ans[i][j] = list.get(j);
                }
                list.clear();
            } else {
                ans[i] = new int[]{};
            }
        }
        return ans;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int[][] ans = search_log(logs, tss);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
