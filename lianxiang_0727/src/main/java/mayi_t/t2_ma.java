package lianxiang_0727.src.main.java.mayi_t;

/**
 * @author Tdd
 * @creat 2022-09-15 20:10
 */
public class t2_ma {


    #include<bits/stdc++.h>

    using namespace std;
    map<int, vector<int>> edge;
    vector<int> weight;
    int ans = 0;
    void dfs(int node, int& ops, unordered_set<int>& visited){
        if(visited.count(node)) return;

        visited.insert(node);
        weight[node] += ops;
        for (int i = 0; i < edge[node].size(); i++) {
            int child = edge[node][i];
            if(child > node) dfs(edge[node][i], ops, visited);
        }
        visited.erase(node);
    }

    int main(){
        int n;
        cin >> n;
        weight.resize(n+1, 1);
        for (int i = 0; i < n - 1; i++) {
            int u, v;
            cin >> u >> v;
            edge[u].push_back(v);
            edge[v].push_back(u);
        }
        for(auto itr = edge.begin(); itr != edge.end(); itr++){
            int node = itr->first;
            if(weight[node] != node){
                unordered_set<int> visited;
                int ops = node - weight[node];
                dfs(node, ops, visited);
                ans += ops;
            }
        }
        cout << ans << endl;
    }


}
