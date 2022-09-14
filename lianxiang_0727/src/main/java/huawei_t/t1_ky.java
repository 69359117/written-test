//package lianxiang_0727.src.main.java.huawei_t;
//
///**
// * @author Tdd
// * @creat 2022-09-14 20:10
// */
//public class t1_ky {
//}
//
//using namespace std;
//int n,m,k;
//int main(){
//    cin>>m>>n>>k;
//    vector<bool> bridge(n+1, true);
//    for(int i = 0; i < k; i++){
//        int hole;
//        cin >> hole;
//        bridge[hole] = false;
//    }
//    vector<vector<int>> dp(n+2, vector<int>(m+2,0));
//    for(int i = 0; i <= m; i++) dp[0][i] = 1;
//    for(int i = 1; i <= n+1; i++){
//        for(int j = 0; j <= m; j++){
//            dp[i][j] = 0;
//            if(i >= 1){
//                if(bridge[i-1] == false){
//                    dp[i][j] += dp[i-1][j+1];
//                }else{
//                    dp[i][j] += dp[i-1][j];
//                }
//            }
//            if(i >= 2){
//                if(bridge[i-2] == false){
//                    dp[i][j] += dp[i-2][j+1];
//                }else{
//                    dp[i][j] += dp[i-2][j];
//                }
//            }
//            if(i >= 3){
//                if(bridge[i-3] == false){
//                    dp[i][j] += dp[i-3][j+1];
//                }else{
//                    dp[i][j] += dp[i-3][j];
//                }
//            }
//        }
//    }
//
//    int ans = 0;
//    for(int i = 1; i <= k; i++){
//        ans += dp[n+1][i];
//    }
//    cout << ans << endl;
//    return 0;
//
//}

int main(){
    int m, n, k;
    cin >> m >> n >> k;
    vector<bool> que(n+2);
    vector<vector<long, long>> dp(n+2, vector<long long>(m+1));
    for(int i = 0, x; i <k; i++){
        cin >> x;
        que[x] = true;
    }
    dp[0][m] = 1;
    long long ans = 0;
    for(int i = 1; i<= n+1; i++){
        for(int j =1; j <= m; j++){
            if(que[i]){
                if(j < m){
                    dp[i][j] = dp[i-1][j+1] + (i -2 >= 0 ? dp[i-2][j+1] : 0) + (i -3 >= 0 ? dp[i-3][j+1] : 0);
                  }
            } else{
                dp[i][j] = dp[i-1][j] + (i -2 >= 0 ? dp[i-2][j] : 0) + (i -3 >= 0 ? dp[i-3][j] : 0);
            }
            if(i == n+1) ans += dp[i][j];
        }
    }
    cout << ans;
    return 0;
}
