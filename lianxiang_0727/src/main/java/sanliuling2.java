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
        int l = nodes.length;
        int[][] ints = new int[l+1][l+1];
        for (int i = 0; i < nodes.length; i++) {
            int x = nodes[i].a;
            ints[nodes[i].a][nodes[i].b] = nodes[i].weight;
            ints[nodes[i].b][nodes[i].a] = nodes[i].weight;
        }
        System.out.println(solution(ints));

        System.out.println(1);

    }

    public static int solution(int[][] Matrix) {
        int ans = 0;
        int num = Matrix.length-1;
        int index = 1;




        return 0;
    }

    static class Node{
        private int a, b;
        private int weight;

        public Node(int a, int b, int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
}
