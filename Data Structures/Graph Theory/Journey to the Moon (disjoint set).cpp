// github.com/andy489

#include <iostream>
using namespace std;
#define MAXN (int)10e5
int p[MAXN], cnt[MAXN];
int parent(int x){ 
    return p[x] = p[x] == x ? x : parent(p[x]); 
}
int main(){
    int n,m,i,x,y;
    cin>>n>>m;
    for(i=0;i<n;++i){
        p[i]=i;        
    }
    for(i=0;i<m;++i){        
        cin >> x >> y;
        int px = parent(x);
        int py = parent(y);
        p[px] = py;
    }
    for(i=0;i<n;++i){        
        ++cnt[parent(i)];
    }
    long long sum = n;    
    sum *= sum;
    for(const int& x:cnt)
        sum -= x*x;
    cout << sum/2;
    return 0;
}
