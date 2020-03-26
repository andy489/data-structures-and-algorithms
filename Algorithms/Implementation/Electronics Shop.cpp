// github.com/andy489

// O(max{nlogn,mlogm})
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int b,n,m,i,j;
    cin >>b>>n>>m;
    vector<int>k(n),u(m);
    for(i=0;i<n;++i){
        cin>>k[i];
    }
    for(i=0;i<m;++i){
        cin>>u[i];
    }
    sort(k.begin(), k.end(),greater<int>());
    sort(u.begin(), u.end(),less<int>());

    int record(-1);

    for(i=0,j=0;i<n;++i){
        for(;j<m;++j){
            int cur=k[i]+u[j];
            if(cur>b){
                break;
            }
            if(cur>record){
                record=cur;
            }
        }
    }

    cout << record;
    return 0;
}
