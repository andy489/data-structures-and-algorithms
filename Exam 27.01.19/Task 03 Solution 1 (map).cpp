#include <bits/stdc++.h>
using namespace std;

int main() {
    map<string, size_t>m;
    string w;
    while(cin>>w){
        ++m[w];
    }
    for(const auto& kvp:m){
        if(kvp.second==1){
            cout<<kvp.first<<'\n';
        }
    }
    return 0;
}
