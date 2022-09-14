package lianxiang_0727.src.main.java.huawei_t;

/**
 * @author Tdd
 * @creat 2022-09-14 20:33
 */
public class t2_ky {
}
int main(){
    cin>>m>>n;
    vector<int> chan(n);
    for(int i = 0; i < n; i++){
        cin >> chan[i];
    }
    sort(chan.begin, chan.end, greater<int>());

    vector<pair<int, int>> pkg(m);
    for(int i = 0; i < m; i++){
        cin >> pkg[i].first;
    }
    for(int i = 0; i < m; i++){
        cin >> pkg[i].second;
    }
    sort(pkg.begin, pkg.end, greater<pair<int, int>>());
    int pos = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < m; i++){
        while(pos < n && chan[pos] >= pkg[i].first){
            pq.push(0);
            pos++;
        }
        int x = pq.top();
        pq.pop();
        pq.push(x+pkg[i].second);
    }
    int ans = 0;
    while(!pq.empty()){
        ans = pq.top();
        pq.pop();
    }
    cout << ans;
    return 0;
}