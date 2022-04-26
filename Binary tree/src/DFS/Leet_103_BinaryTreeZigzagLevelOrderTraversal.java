package DFS;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jjzmi
 * @description 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *              例如：
 *              给定二叉树 [3,9,20,null,null,15,7],
 *              3
 *             / \
 *            9  20
 *              /  \
 *             15   7
 *              返回锯齿形层序遍历如下：
 *             [
 *               [3],
 *               [20,9],
 *               [15,7]
 *              ]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * @create 2021-03-28-22:11
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Leet_103_BinaryTreeZigzagLevelOrderTraversal {
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

    /**
     * 返回其节点值的锯齿形层序遍历
     * @param root 根节点
     * @return 返回List<list<Integer>> 对应着每层的list
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        //奇数行栈
        Stack<TreeNode> stack1 = new Stack<>();
        //偶数行栈
        Stack<TreeNode> stack2 = new Stack<>();

        if (root == null) { return lists; }


        stack1.push(root);
        while (stack1.size() != 0 || stack2.size() != 0) {
            List<Integer> list1 = new ArrayList<>();
            if (stack1.size() != 0) {
                int time = stack1.size();
                while (time > 0) {
                    TreeNode current = stack1.pop();
                    list1.add(current.val);
                    if (current.left != null) {

                        stack2.push(current.left);
                    }
                    if (current.right != null) {
                        stack2.push(current.right);
                    }
                    --time;
                }
                lists.add(list1);
            }else {
                int time1 = stack2.size();
                while (time1 > 0) {
                    TreeNode current = stack2.pop();
                    list1.add(current.val);
                    if (current.right != null) {

                        stack1.push(current.right);
                    }
                    if (current.left != null) {
                        stack1.push(current.left);
                    }
                    --time1;
                }
                lists.add(list1);
            }
        }
        return lists;
    }

    /**
     * String---> B_Tree   BFS 反序列化
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
        String s = "[3,9,20,null,null,15,7]";
        TreeNode root = BFSDeserialize(s);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);

    }

}
