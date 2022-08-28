import java.util.Scanner;

public class juxingchongdie {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           // 数据组数
        int m = sc.nextInt();           // 组内元素数

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] ints = new int[m][4];
                for (int k = 0; k < 4; k++) {
                    ints[j][k] = sc.nextInt();
                }
                sc.nextLine();
                System.out.println(1);
            }

        }
    }




}
