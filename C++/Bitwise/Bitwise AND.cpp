// github.com/andy489

#include <iostream>
using namespace std;

int main(){
    int q;
    cin >> q;
    while(q--){
        int n,k;
        cin>>n>>k;
        if(((k-1)|k)<=n){
            cout<<k-1<<'\n';
        }
        else{
            cout<<k-2<<'\n';
        }

    }
    return 0;
}
