package wangyi0820;

import java.time.temporal.Temporal;

/**
 * @author Tdd
 * @creat 2022-08-23 11:26
 * <p>
 * 二叉树 两个节点  返回两个节点的距离
 * <p>
 * 思路：先找两个节点的公共祖先
 * 再从公共祖先出发，找两节点距离
 *
 *

 */
public class test02 {
    public static void main(String[] args) {
        String[] s = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        //把输入字符串输入，转为二叉树节点数组
        TreeNode[] nodes = new TreeNode[s.length];
        for (int i = 0; i < s.length; i++) {
            nodes[i] = null;
            if (!s[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.parseInt(s[i]));
            }
        }
        //构造二叉树
        for (int i = 0; 2 * i + 2 < nodes.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[2 * i + 1];
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        TreeNode head = nodes[0];//1
        TreeNode p = nodes[1];//2
        TreeNode q = nodes[5];//6

        TreeNode parent = CommonAncestor(head, p, q);
        int o = rootDistance(head, parent) - 1;
        int d1 = rootDistance(head, p) - 1;
        int d2 = rootDistance(head, q) - 1;
        System.out.println(d1 + d2 - 2 * o);
    }

    //1.找最近公共祖先
    public static TreeNode CommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = CommonAncestor(root.left, p, q);
        TreeNode right = CommonAncestor(root.right, p, q);
        if (right == null) return left;
        if (left == null) return right;
        return root;
    }

    //2.找根节点到给定节点的距离(距离加1）
    public static int rootDistance(TreeNode root, TreeNode node) {
        if (root == node) return 1;
        if (root == null) return 0;
        int left = rootDistance(root.left, node);
        int right = rootDistance(root.right, node);
        //后序
        if (left != 0) return left + 1;
        else if (right != 0) return right + 1;
        else return 0;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
