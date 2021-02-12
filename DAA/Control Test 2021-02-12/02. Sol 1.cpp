#include <iostream>
#include <algorithm>
using namespace std;
pair<int, pair<int, int>> x[100000];
int d[10000], p[10000], n, m, q[10000], taken[10000];

void unite(int f, int t){
    if(d[f] > d[t])
        p[t] = f;
    else
        p[f] = t;
    if(d[f] == d[t])
        d[t] ++;
}

int root(int x){
    if(p[x] == x)
        return x;
    return p[x] = root(p[x]);
}

int main(){
    cin>>n;
    for(int i=0;i<n;++i){
        cin>>q[i];
    }
    cin>>m;
    for(int i=0;i<m;++i){
        cin>>x[i].second.first>>x[i].second.second>>x[i].first;
    }

    sort(x, x+m);
    for(int i=0;i<n;++i){
        p[i] = i;
    }
    int ans = 0, br = 0;
    for(int i=0;i<m;++i) {
        int f = x[i].second.first-1;
        int t = x[i].second.second-1;
        int v = x[i].first;
        if(q[f] > q[t] && !taken[t]) {
            if(root(f) != root(t)){
                taken[t] = 1;
                unite(f, t);
                ans += v;
                br++;
            }
        }
    }
    if(br == n-1)
        cout<<ans<<endl;
    else
        cout<<-1<<endl;
}
