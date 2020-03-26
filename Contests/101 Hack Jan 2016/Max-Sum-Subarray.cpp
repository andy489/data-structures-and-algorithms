// github.com/andy489

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n,x;
    int best_sum(0), cur_sum(0);
    cin>>n;
    while(n--){
        cin>>x;
        x=x==0?-INT_MIN:x;
        cur_sum=max(0,cur_sum+x);
        best_sum=max(cur_sum,best_sum);       
    }
    cout<<best_sum;
    return 0;
}
