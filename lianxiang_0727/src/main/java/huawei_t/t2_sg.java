package lianxiang_0727.src.main.java.huawei_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-14 20:01
 */
public class t2_sg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        int[] hold = new int[n];
        for (int i = 0; i < n; i++) hold[i] = sc.nextInt();

    }
}

#include<iostream>
using namespace std;

int m,n,ans = INT_MAX;
vector<int>v1,v2,v3;
vector<int>dp;
void func(int k){
    if(k == m){
        int tmp = dp[0];
        for(int i = 0; i < n; ++i)
        if(tmp < dp[i]) tmp = dp[i];
        if (tmp < ans)ans = tmp;
        return;
    }

    for(int i = 0; i < n; ++i){
        if(v1[i] >= v2[k]){
            dp[i] += v3[k]; func(k+1);
            dp[i] -= v3[k];
        }
    }
}

int main(){
    cin>>m>>n;
    v1.resize(n,0);
    v2.resize(m,0);
    v3.resize(m,0);
    dp.resize(n,0);
    for(int i = 0; i < n; ++i)cin>>v1[i];
    for(int i = 0; i < m; ++i)cin>>v2[i];
    for(int i = 0; i < m; ++i)cin>>v3[i];
    func(0);
    cout<<ans;
    return 0;
}