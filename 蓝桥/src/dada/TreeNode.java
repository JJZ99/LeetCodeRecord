package dada;

/**
 * @author jjzmi
 * @description
 * @create 2021-03-20-12:09
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
class TreeNode {
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
