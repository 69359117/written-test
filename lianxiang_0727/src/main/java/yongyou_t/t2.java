package yongyou_t;

import java.util.*;

//0,0,0,0,0,0,0,0
//

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        String s ;
        while ( !( s = sc.nextLine() ).equals("") ){
            strings.add(s);
        }
        for (String string : strings) {
            System.out.println(string.toString());
        }
        int m = strings.size();
        int n = strings.get(0).length()/2 +1;
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s1 = strings.get(i);
            String[] split = s1.split(",");
            for (int i1 = 0; i1 < split.length; i1++) {
                ints[i][i1] = Integer.valueOf(split[i1]);
            }
        }
        System.out.println(maxAreaOfIsland(ints));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(grid[i][j] == 0) return 0;// 已经是海水了

        grid[i][j] = 0;
        return dfs(grid, i-1, j) + dfs(grid, i+1, j) +
                dfs(grid, i, j-1) + dfs(grid, i, j+1) + 1;
    }
}
