package com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jjz
 * @project LeetCode
 * @description: Serialize and Deserialize Binary Tree（二叉树的序列化与反序列化）
 *                请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 *                反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为
 *                一个字符串并且将这个字符串反序列化为原始的树结构。
 *                对于不同的反序列化方法 out也不一定相同
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 * @school JSU
 * @create 2021-02-08-21:52
 */
public class SerAndDeserBT {

    final static String SEP = ",";
    final static String NULL = "#";

    //先序
    // Encodes a tree to a single string.
    public static String serialize(EqualValueNum.TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serial(root, sb);
        return sb.toString();
    }

    public static void serial(EqualValueNum.TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serial(root.left, sb);
        serial(root.right, sb);
    }
    //先序
    // Decodes your encoded data to tree.
    public static EqualValueNum.TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);

        }
        return deseria(nodes);
    }

    public static EqualValueNum.TreeNode deseria(LinkedList<String> nodes){
        if(nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if(first.equals(NULL)) {
            return null;
        }
        EqualValueNum.TreeNode root = new EqualValueNum.TreeNode(Integer.parseInt(first));

        root.left = deseria(nodes);
        root.right = deseria(nodes);

        return root;
    }

    //宽度优先或者广度优先 逐层遍历借助队列
    public static String BFSserialize(EqualValueNum.TreeNode root) {
        //tree: [v1,v2,null,...]
        StringBuilder res = new StringBuilder();
        Queue<EqualValueNum.TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            EqualValueNum.TreeNode cur = queue.remove();
            if(cur == null){
                res.append("null,");
            }else{
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    public static EqualValueNum.TreeNode BFSdeserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        int length=nodes.size();
        String first = nodes.removeFirst();
        if(first.equals(NULL)) {
            return null;
        }

        EqualValueNum.TreeNode root = getNode(first);
        Queue<EqualValueNum.TreeNode> parents = new LinkedList();
        EqualValueNum.TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < length; i++){
            EqualValueNum.TreeNode cur = getNode(nodes.removeFirst());
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

    private static EqualValueNum.TreeNode getNode(String val){
        if(val.equals(NULL)){
            return null;
        }
        return new EqualValueNum.TreeNode(Integer.valueOf(val));
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        String s="1,2,3,#,#,4,5";
        System.out.println(s);
        EqualValueNum.TreeNode root = BFSdeserialize(s);
        String s2 = BFSserialize(root);
        System.out.println(s2);
    }
}


