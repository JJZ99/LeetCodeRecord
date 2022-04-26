package lesson01;

import sun.java2d.Surface;

import java.util.*;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-01-13:55
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Code03_KM {
    public static HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 一般方法 hashmap
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int hashMapKTAction(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 一个数组中有一种数出现了K次，其他的数字均出现了M次，且M>1 , K<M
     * 要求：空间复杂度O(1) 时间复杂度O（N）
     *
     * @param arr 数组
     * @param k   出现k次
     * @param m   出现m次
     * @return 出现了K次的数
     */
    public static int onlyKTimes(int[] arr, int k, int m) {

        int[] t = new int[32];
        for (int a : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += ((a >> i) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //如果在i  上有一
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        //可能会出现k次数是0的情况，这里要判断一下
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }

    /**
     * 产生一个随机数组,数组中有一种数出现了K次，其他的数字均出现了M次
     *
     * @param kinds 数的种类
     * @param range 数的范围
     * @param k
     * @param m
     * @return 返回一个随机数组
     */
    public static int[] randomArray(int kinds, int range, int k, int m) {
        int length = k + m * (kinds - 1);
        int[] arr = new int[length];
        int numKinds = randomNumber(range);
        int index = 0;
        for (; index < k; index++) {
            arr[index] = numKinds;
        }
        kinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(numKinds);
        for (; kinds > 0; --kinds) {
            int curNum = 0;
            //直到取到了没产生过的数据
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        //arr填好了现在我让他们无序
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }



    /**
     * 返回一个 -range range 的整数
     *
     * @param range
     * @return
     */
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range + 1) - (int) (Math.random() * range + 1));
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int kinds = 10;
        int range = 30;
        int testTimes = 50000;
        int max = 9;
        int k = (int) (Math.random() * max + 1);
        int m = (int) (Math.random() * max + 1);
        if (k == m) {
            m++;
        }
        System.out.println("测试开始----------------------------");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = randomArray(kinds, range, k, m);
            int ans = onlyKTimes(arr, k, m);
            int ans2 = hashMapKTAction(arr, k, m);
            System.out.println(ans == ans2 ? "第" + i + "次 Success！" : "第" + i + "次fuck fucking");
            if (ans != ans2) {
                System.out.println(arr);
                System.out.println("ans:" + ans);
                System.out.println("ans2" + ans2);
                return;
            }
        }
    }
}
