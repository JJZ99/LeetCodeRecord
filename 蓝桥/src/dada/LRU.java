package dada;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jjzmi
 * @description
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]:
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * @create 2021-03-20-16:26
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class LRU {

    /**
     * 二维数组中第0位即：[1,1,1]，第一个1表示opt=1，要set(1,1)，即要将(1,1)插入缓存
     * 二维数组中第1为即：[1,2,2]，第一个1表示opt=1，要set(2,2)，即要将(2,2)插入缓存
     * 二维数组中第2位即：[1,3,2]，第一个1表示opt=1，要set(3,2)，即要将(3,2)插入缓存
     * 二维数组中第3位即：[2,1]，第一个2表示opt=2，要get(1)，即从缓存中查找key为1的值，
     * 前面已经插入了key=1，所以返回1，这个要保存到返回数组中
     * 二维数组中第5位即：[2,2]，第一个2表示opt=2，要get(2)，即从缓存中查找key为2的值，由于缓存大小为3，
     * 所以前面插入的key=2已经被挤出缓存，所以返回结果为-1，这个要保存到返回数组中
     * @param operators
     * @param k
     * @return
     */
    public static int[] LRUSolve (int[][] operators, int k) {
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] operator : operators) {
            int key = operator[1];
            switch (operator[0]) {
                case 1:
                    int value = operator[2];
                    if (!list.containsKey(key)) {
                        if (list.size() >= k) {
                            Iterator iterator = list.keySet().iterator();
                            list.remove(iterator.next());
                        }
                    }
                    System.out.println(list.put(key, value));
                    break;
                case 2:
                    int val = -1;
                    if (list.containsKey(key)) {
                        val = list.get(key);
                        list.remove(key);
                        list.put(key, val);
                    }
                    arrayList.add(val);
                    break;
                default:
            }
        }
        System.out.println(list.toString());
        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arrayList.get(i);
        }
        return ans;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        int [] [] options ={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        System.out.println(Arrays.toString(LRUSolve(options, 3)));

        Deque deque = new ArrayDeque<>();
        byte a = 127;
        System.out.println(Integer.toOctalString(a));


    }
}
