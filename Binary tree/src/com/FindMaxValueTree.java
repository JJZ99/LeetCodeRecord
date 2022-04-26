package com;

import java.util.*;

/**
 * @author jjzmi
 * @description leetcode.515 在每个树行中找最大值
 * @create 2021-02-19-11:33
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class FindMaxValueTree {

    final static String SEP = ",";
    final static String NULL = "null";

    /**
     * 广度遍历，每循环一次代表一层 每层循环都找出最大值max
     */
    public static List<Integer> Solution(EqualValueNum.TreeNode root){

        List<Integer>  list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<EqualValueNum.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int max=queue.peek().val;
            for (int i = 0; i <size ; i++) {
                EqualValueNum.TreeNode node=queue.poll();
                if (max<node.val){
                    max=node.val;
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }

    /**
     * 也可以用递归 多一个深度参数 每层的最大节点add到list2
     * @param root
     * @param depth
     * @return 集合
     */
    public  List<Integer>  list2=new ArrayList<>();
    public  static void Solution2(EqualValueNum.TreeNode root, int depth){


    }
    //广度遍历的 反序列化方法
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

        String s="1,3,2,5,3,null,9";
        EqualValueNum.TreeNode root = BFSdeserialize(s);
        List<Integer> list = Solution(root);
        System.out.println(list.toString());
    }


}


