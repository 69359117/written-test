import java.util.PriorityQueue;
import java.util.Scanner;

public class tengxunyinyue3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(getTreeSum(node1));

    }


    public static int getTreeSum(TreeNode tree){
        if(tree.left == null){
            return 1;
        }
        int left = getTreeSum(tree.left);
        int right = getTreeSum(tree.right);

        int tem = Math.max(left,right);
        return (tem*2) % 1000000007+1 ;
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


