package com;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jjz
 * @project LeetCode
 * @description:  题意是说如果一个结点的左子树和右子树的值都相等, 那么就计数+1.
 *                 因此我们只需要一个递归的判定一个结点出发,是否其所有结点都相等即可.叶子结点也算是一个结果.
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-13-11:05
 */
public class EqualValueNum {
    final static String SEP = ",";
    final static String NULL = "null";

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode() {
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //宽度优先或者广度优先 逐层遍历借助队列
    public static String BFSserialize(TreeNode root) {
        //tree: [v1,v2,null,...]
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if(cur == null) {
                res.append("null,");
            }else {
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    //广度遍历的 反序列化方法
    public static TreeNode BFSdeserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        int length=nodes.size();
        String first = nodes.removeFirst();
        if(first.equals(NULL)) {
            return null;
        }
        TreeNode root = getNode(first);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < length; i++){
            TreeNode cur = getNode(nodes.removeFirst());
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private static TreeNode getNode(String val){
        if(val.equals(NULL)){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    //先序遍历得到所有的节点
    public static List<TreeNode> getNodeSerialize(TreeNode root) {
        List<TreeNode> list = new LinkedList();
        serial(root, list);
        return list;
    }

    public static void serial(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        serial(root.left, list);
        serial(root.right, list);
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {
        int counter = 0;
        //String s="5,1,5,5,5,null,5";
        String s="0,1,0,null,null,1,0,1,1,null,null";
        System.out.println("输入："+s);
        TreeNode root = BFSdeserialize(s);
        List<TreeNode> list = getNodeSerialize(root);
        //对各个节点的左右节点判断
        for (int i = 0; i <list.size() ; i++) {
            TreeNode node=list.get(i);
            if(node.left!=null&&node.right!=null&&(node.left.val==node.right.val)) counter++;
            if (node.left==null&&node.right==null) counter++;
        }
        String s2 = BFSserialize(root);
        System.out.println("序列化输出："+s2);
        System.out.println("counter:"+counter);
    }
}



