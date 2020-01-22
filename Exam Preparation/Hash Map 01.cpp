//https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2298
#include <bits/stdc++.h>
using namespace std;

int main(){ 
    int N,M,t;
    long s(0);
    string c;
    cin>>N>>M; 
    
    unordered_map<string, int>um;
    
    while(N--){
        cin>>c>>t;
        um[c]=t;
    }
    while(M--){
        cin>>c;
        s+=um[c];
    }
    cout<<s;    
}
