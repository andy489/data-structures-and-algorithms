#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n,i;
    cin>>n;
    int *a=new int[n];
    for(i=0;i<n;++i){
        cin>>a[i];
    }
    int q,x;
    cin>>q;
    while(q--){
        cin>>x;
        if(*lower_bound(a,a+n,x)==x){
            cout<<"Yes "<<lower_bound(a,a+n,x)-a+1<<'\n';
        }
        else{
            cout<<"No "<<lower_bound(a,a+n,x)-a+1<<'\n';
        }
    }
    return 0;
}
