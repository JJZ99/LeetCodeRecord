package com.DailyCodingProblem;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author jjzmi
 * @description Microsoft-二叉树表示的算术计算式
 *               Suppose an arithmetic expression is given as a binary tree.
 *               Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 *              Given the root to such a tree, write a function to evaluate it.
 *              For example, given the following tree:
 *              *
 *             / \
 *            +    +
 *           / \  / \
 *          3  2  4  5
 *          You should return 45, as it is (3 + 2) * (4 + 5).
 * @create 2021-03-30-10:43
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Day50_BT_ArithmeticExpression {

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(String val) { this.val = val; }
        TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private static TreeNode getNode(String val) {
            if (val.equals(NULL)) {
                return null;
            } else {
                return new TreeNode(val);
            }
        }
    }

    /**
     * 表达式字符串
     */
    static String exp = "";

    final static String NULL = "null";

    public static void solution(TreeNode root) {
        inOrder(root);
    }

    /**
     * 中序
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            exp += root.val;
            inOrder(root.right);
        }

    }

    /**
     * 先序
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            exp += root.val;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 后序
     * @param root
     */
    public static double postOrder(TreeNode root) {

        if (root != null) {
            double left = postOrder(root.left);
            double right = postOrder(root.right);
            //如果左右节点全为空 那么肯定是个数，不是运算符
            if (left == Double.MIN_VALUE && right == Double.MIN_VALUE) {
                return Double.parseDouble(root.val);
            } else {
                switch (root.val) {
                    case "+":
                        return left + right;
                    case "-":
                        return left - right;
                    case "*":
                        return left * right;
                    case "/":
                        return left / right;
                    case "%":
                        return left % right;
                    default:
                        return 0;
                }
            }
        }
        //如果为空
        return Double.MIN_VALUE;

    }

    /**
     * 反序列化 广度
     * @param data 字符串[5,5,8,6,....]
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        if (split[0] == NULL) {
            return null;
        }


        LinkedList<String> nodes = new LinkedList<>();
        for (String s : split) {
            nodes.offer(s);
        }
        int len = nodes.size();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = TreeNode.getNode(nodes.pop());
        boolean flag = true;
        TreeNode parent = root;
        for (int i = 1; i < len; i++) {
            TreeNode current = TreeNode.getNode(nodes.pop());
            if (flag) {
                parent.left = current;
            } else {
                parent.right = current;
            }
            if (current != null) {
                queue.offer(current);
            }
            flag = !flag;
            if (flag) {
                parent = queue.poll();
            }
        }
        return root;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        String s = "[5,5,1,null,7,2,null]";
        TreeNode root = deserialize(s);
        solution(root);
        System.out.println(exp);

        String s2 = "[/,1,+,null,null,4,5]";
        TreeNode root2 = deserialize(s2);
        System.out.println(postOrder(root2));


    }

}
