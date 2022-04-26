package com;

import com.EqualValueNum.TreeNode;
import sun.java2d.Surface;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jjzmi
 * @description 二叉树中和为某一值的路径  例如目标值为16
 *                5
 *              / \
 *             3   6
 *            /   / \
 *            8  13  4
 *          /  \    / \
 *         7    2  5   1
 *     输出 5 3 8和5 6 4 1
 *     这里和原题不同的是不一定非要是根节点到叶子节点的路径
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * @create 2021-03-27-18:55
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class PathSum {

    static final String NULL = "null";

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static LinkedList<List<Integer>> lists = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        help(root, target);
        return lists;
    }

    private  static void help(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        path.add(root.val);
        //如果是路径要是从根节点到叶子节点，应该改成这样
        //if (target == 0&& root.left == null && root.right == null) {
        if (target == 0) {
            lists.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        help(root.left, target);
        help(root.right, target);
        path.removeLast();
    }

    /**
     * String---> B_Tree   BFS
     * @param data 字符串[5,5,8,6,....]
     * @return
     */
    public static TreeNode BFSDeserialize(String data) {

        if (data == null || data.length() <= 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        if (split[0] == NULL) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int time = split.length;

        int flag = 0;
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        for (int i = 1; i < time; i++) {
            TreeNode currentNode = queue.poll();
            if (!split[i].equals(NULL)) {
                currentNode.left = new TreeNode(Integer.parseInt(split[i]));
                //加入队列
                queue.add(currentNode.left);
            } else {
                currentNode.left = null;
            }
            ++i;
            //这里面要判断是否越界
            if (i < split.length && !split[i].equals(NULL)) {
                currentNode.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(currentNode.right);

            } else {
                currentNode.right = null;
            }
        }
        return root;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        String s = "[5,3,6,8,null,13,4,7,2,null,null,5,1]";
        //s = s.substring(1, s.length() - 1);
        //System.out.println(s);
        TreeNode root = BFSDeserialize(s);
        System.out.println(pathSum(root, 16));




    }
}
