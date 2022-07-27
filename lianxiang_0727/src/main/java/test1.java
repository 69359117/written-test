package tjh07;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-07-27 20:59
 */
public class t11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[][] temp = new String[N][2];
        for(int i = 0; i < N; i++){
            temp[i][0] = scanner.next();
            temp[i][1] = scanner.next();
        }

        int start = 0;
        int sumHour = 0, sumMinus = 0, sumSecond = 0;


        while(start < N){
            while(start < N && temp[start][0].equals("out")) start++;
            if(start >= N) break;

            //输入时间
            int inHour = 0;
            int inMinits = 0;
            int inSecond = 0;
            while(start < N && temp[start][0].equals("in")){//输入时间选择最后一次
                String[] inTime = temp[start][1].split(":");
                inHour = Integer.valueOf(inTime[0]);
                inMinits = Integer.valueOf(inTime[1]);
                inSecond = Integer.valueOf(inTime[2]);
                start++;
            }
            if(start >= N) break;

            //输出时间选第一次的
            String[] outTime = temp[start][1].split(":");
            int outHour = Integer.valueOf(outTime[0]);
            int outMinits = Integer.valueOf(outTime[1]);
            int outSecond = Integer.valueOf(outTime[2]);
            start++;

            if(outSecond - inSecond >= 0) sumSecond += outSecond - inSecond;
            else {
                sumSecond +=  60 + outSecond - inSecond;
                outMinits--;
            }
            if(outMinits - inMinits >= 0) sumMinus += outMinits - inMinits;
            else {
                sumMinus += 60 + outMinits - inMinits;
                outHour--;
            }
            if(outHour - inHour >= 0) sumHour += outHour - inHour;
            else {

            }



        }
        while(sumSecond > 60){
            sumMinus++;
            sumSecond-=60;
        }
        while(sumMinus > 60){
            sumHour++;
            sumMinus-=60;
        }
        if(sumHour < 10)
            System.out.println("0" + sumHour+":"+sumMinus+":"+sumSecond);
        else
            System.out.println(sumHour+":"+sumMinus+":"+sumSecond);
    }


}
