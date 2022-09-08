import java.util.PriorityQueue;
import java.util.Scanner;

public class tengxunyinyue3 {

    public static long sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;

        dfs(node1);
        System.out.println(sum+1);

    }


    public static long dfs(TreeNode node){
        if(node.left == null){
            return 1;
        }
        long left = dfs(node.left);
        long right = dfs(node.left);

        long tem = Math.max(left,right);
        sum += tem*2;
        return tem*2+1 ;
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


