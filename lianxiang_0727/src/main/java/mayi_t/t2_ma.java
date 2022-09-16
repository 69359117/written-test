//package lianxiang_0727.src.main.java.mayi_t;
//
///**
// * @author Tdd
// * @creat 2022-09-15 20:10
// */
//public class t2_ma {
//
//
//    #include<bits/stdc++.h>
//
//    using namespace std;
//    map<int, vector<int>> onesize;
//    vector<int> kmpWie;
//    int result = 0;
//    void dfs(int nodeTree, int& optional, unordered_set<int>& hasKnowed){
//        if(hasKnowed.count(nodeTree)) return;
//
//        hasKnowed.insert(nodeTree);
//        kmpWie[nodeTree] += optional;
//        for (int i = 0; i < onesize[nodeTree].size(); i++) {
//            int child = onesize[nodeTree][i];
//            if(child > nodeTree) dfs(onesize[nodeTree][i], optional, hasKnowed);
//        }
//        hasKnowed.erase(nodeTree);
//    }
//
//    int main(){
//        int n;
//        cin >> n;
//        kmpWie.resize(n+1, 1);
//        for (int i = 0; i < n - 1; i++) {
//            int u, v;
//            cin >> u >> v;
//            onesize[u].push_back(v);
//            onesize[v].push_back(u);
//        }
//        for(auto itr = onesize.begin(); itr != onesize.end(); itr++){
//            int nodeTree = itr->first;
//            if(kmpWie[nodeTree] != nodeTree){
//                unordered_set<int> hasKnowed;
//                int optional = nodeTree - kmpWie[nodeTree];
//                dfs(nodeTree, optional, hasKnowed);
//                result += optional;
//            }
//        }
//        cout << result << endl;
//    }
//
//
//}
