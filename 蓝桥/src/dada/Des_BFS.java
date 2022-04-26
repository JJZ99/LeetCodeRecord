package dada;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-20-11:09
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class Des_BFS {

    /**
     * 给定一个二叉树，返回该二叉树层序遍历的结果
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();


        if (root == null) {
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            arrayLists.add(list);
        }
        return arrayLists;
    }

}
