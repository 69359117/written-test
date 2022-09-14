package Old;

import java.util.Scanner;

public class tengxunyinyue3_ {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;

        System.out.println(getTreeSum(node1));

    }


    public static int getTreeSum(TreeNode tree){
        long dfs = dfs(tree);
        return (int)( (dfs) % 1000000007 ) ;
    }

    public static long dfs(TreeNode tree){
        if(tree.left == null){
            return 1;
        }
        long left = dfs(tree.left);
        long right = dfs(tree.right);

        long tem = Math.max(left,right);
        return (tem*2) +1 ;
    }

    public static class TreeNode{
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }

}


