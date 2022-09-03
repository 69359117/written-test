package wangyi0820;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tdd
 * @creat 2022-08-23 11:44

 * m*n数组
 * 螺旋打印 二维数组
 *
 *
 */
public class test03 {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = solution(input);
        for(Integer i : list) System.out.print(i + " ");
    }

    public static List<Integer> solution(int[][] matrix){
        int l = 0, r = matrix[0].length - 1;//左右边界，都是左闭右闭区间
        int u = 0, d = matrix.length - 1;//上下边界
        List<Integer> list = new ArrayList<>();
        while(l <= r && u <= d){
            for(int i = l; i <= r; i++){//①从左到右一行（上侧）
                list.add(matrix[u][i]);
            }
            u++;
            if(l > r || u > d) break;

            for(int i = u; i <= d; i++){//②从上到下一行(右侧)
                list.add(matrix[i][r]);
            }
            r--;
            if(l > r || u > d) break;

            for(int i = r; i >= l; i--){//③从右往左一行（下侧）
                list.add(matrix[d][i]);
            }
            d--;
            if(l > r || u > d) break;

            for(int i = d; i >= u; i--){//④从下往上一行（左侧）
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }
}
