import java.util.Scanner;

public class sanliuling2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();//节点数n和道路数m
        int[][] path = new int[m][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < m; j++){
                path[i][j] = sc.nextInt();
            }
        }

        Node[] nodes = new Node[m];
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(path[0][i], path[1][i], path[2][i]);
        }

    }

    public static int solution(int[][] Matrix) {

        return 0;

    }
}
