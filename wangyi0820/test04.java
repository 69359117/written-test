package wangyi0820;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Tdd
 * @creat 2022-08-23 14:48
 */
public class test04 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode father;

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
                nodes[2 * i + 1].father = nodes[i];//构造父节点
                nodes[i].right = nodes[2 * i + 2];
                nodes[2 * i + 2].father = nodes[i];//同上
            }
        }
        TreeNode head = nodes[0];//1
        TreeNode p = nodes[1];//2
        TreeNode q = nodes[5];//6
        TreeNode ancestor = lowestCommonAncestor(p, q);
        System.out.println(ancestor.val);//1
        p = nodes[3];//4
        q = nodes[4];//5
        ancestor = lowestCommonAncestor(p, q);
        System.out.println(ancestor.val);//2
    }

    public static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q){
        TreeNode cur1 = p;
        TreeNode cur2 = q;
        //p和q都往父节点走，当cur1 == cur2 说明找到第一个重复节点
        while(cur1 != cur2){
            cur1 = cur1 != null ? cur1.father : q;
            cur2 = cur2 != null ? cur2.father : p;
        }
        return cur1;
    }


}
