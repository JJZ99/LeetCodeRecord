package jjz;

import java.util.*;

/**
 * @author: zhaojunjie
 * @e-mail: jjz.miss.3344@outlook.com
 * @date: 2022-04-26-14:13
 * @description: https://leetcode-cn.com/problems/two-sum/
 */
public class C1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5,6};
        int target = 10;
        nums = twoSum(nums, target);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
