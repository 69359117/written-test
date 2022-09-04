package Old;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tdd
 * @creat 2022-08-26 19:26
 */
public class weiruan5 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,4,3};
        int[] B = new int[]{1,3,2,3};
        System.out.println(solution(A, B, 4));          // 2

        A = new int[]{3,2,1,6,5};
        B = new int[]{4,2,1,3,3};
        System.out.println(solution(A, B, 5));          // 3

        A = new int[]{1,2};
        B = new int[]{1,2};
        System.out.println(solution(A, B, 2));          // 3

        A = new int[]{3,4,4,4};
        B = new int[]{4,4,4,5};
        System.out.println(solution(A, B, 4));          // 应返回1
    }

    public static int solution(int[] A, int[] B, int N){
        Set<Integer> set = new HashSet<>();             // 存储被选定的数
        for (int i = 0; i < N; i++) {
            if(A[i] == B[i]){
                set.add(A[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            if(A[i] != B[i]){
                if(set.contains(A[i]) || set.contains(B[i])){     // A[i] 或 B[i] 已确定
//                    continue;
                }else {
                    set.add( Math.max(A[i],B[i]) );
                }
            }
        }

        for (int i = 1; i < 100001; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return 100001;


//
//        int[] C = new int[N];
//        Arrays.fill(C, Integer.MAX_VALUE);
//        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for(int i = 0; i < N; i++){
//            if(A[i] == B[i]){
//                set.add(A[i]);//相同的肯定已经有了
//                C[i] = A[i];
//                max = Math.max(A[i], max);
//            }
//        }
//        if(set.size() == N) return max + 1;//全部相等时
//
//        for(int i = 0; i < N; i++){
//            if(set.contains(A[i])) C[i] = B[i];//包含一个，则加另一个（使得C[i]可能的元素大小 尽可能多）
//            else if(set.contains(B[i])) C[i] = A[i];
//            else{//其他情况取较大值
//                if(A[i] > B[i]) C[i] = A[i];//取较大值
//                else C[i] = B[i];
//            }
//            if(A[i] != B[i]) min = Math.min(min, Math.min(A[i], B[i]));
//            set.add(C[i]);
//            max = Math.max(max, C[i]);//找到C中最大值为max
//        }
//        for(int i = 1; i <= max; i++){
//            if(!set.contains(i)) return i;
//        }
//        return min;
    }

}