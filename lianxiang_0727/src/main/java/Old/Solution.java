package Old;

class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.numSimilarGroups(new String[] {"tars","rats","arts","star"});


    }

    int[] f;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];             // 记录节点的所属
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);         // 更新所属至最高层
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {       // 若相似
                    f[fi] = fj;                         // i 所属节点 的 所属、更新为 j 所在的所属
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {           // 组数
            if (f[i] == i) {
                ret++;
            }
        }
        return ret;
    }


    public int find(int x) {       // 将 x 的所属、更新为 父节点所属，并返回（保证获取到关联树的根节点）
        return f[x] == x ? x : ( f[x] = find(f[x]) );
    }


    public boolean check(String a, String b, int len) {     // 检查 a、b 是否相似
        int num = 0;
        for (int i = 0; i < len; i++) {
            if ( a.charAt(i) != b.charAt(i) ) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
