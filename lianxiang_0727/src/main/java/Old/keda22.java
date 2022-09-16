package Old;

import java.util.*;

//9 4
//1 5
//3 6
//7 7
//6 9



public class keda22 {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int way = cin.nextInt();
        int n = cin.nextInt();

        TreeSet<int[]> ants = new TreeSet<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int[] ant = new int[2];
            ant[0] = cin.nextInt();
            ant[1] = cin.nextInt();
            ants.add(ant);
        }

        solution(way,ants);
    }

    public static void solution(int way,TreeSet<int[]> ants){
        int res= 0;
        boolean start = true;
        int l=-99 ,r=-99 ,temR = -99 ,temIndex = -99 ;
        for (int[] ant : ants) {
            if(start){
                start = false;
                if(ant[0]!=1){
                    System.out.println(false);
                    return;
                }else {
                    res++;
                    r = ant[1];
                    temR = ant[1];
                    continue;
                }
            }
            if(ant[0] <= r+1){
                if(ant[1] > temR){
                    temR = ant[1];
                }
            }else {
                res++;
                r = temR;
            }


        }

        if(r >= way){
            System.out.println(res);
        }else {
            System.out.println(false);
        }
    }
}

