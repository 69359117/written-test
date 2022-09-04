package Old;

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
        int[][] ints = new int[l][l];
        for (int i = 0; i < nodes.length; i++) {
            int x = nodes[i].a;
            ints[nodes[i].a-1][nodes[i].b-1] = nodes[i].weight;
            ints[nodes[i].b-1][nodes[i].a-1] = nodes[i].weight;
        }
        System.out.println(solution(ints));

//        System.out.println(1);

    }

    public static int solution(int[][] Matrix) {
        int sum = 0;
        int num = Matrix.length-1;
        int index = 0;
        int[] has = new int[num];
        int[] weights = new int[num];



        for (int i = 0; i < num; i++) {
            weights[i] = Matrix[index][i];
        }
        weights[index] = 0;
        int tem = 0;
        for (int i = 0 ; i<num ; i++){

            int min = Integer.MAX_VALUE;
            for (int j = 0 ; j <num ; j++){
                if(weights[j]!=0 && weights[j]<min){
                    min = weights[j];
                    tem = j;
                }
            }

            sum+=weights[tem];

            weights[tem] = 0;

            for (int kk = 0; kk < num; kk++) {
                if(weights[kk]!=0 && Matrix[tem][kk]<weights[kk]){
                    weights[kk] = Matrix[tem][kk];
                }
            }

        }



        return sum;
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
