#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,h; size_t routes(0);
    cin>>n;
    stack<pair<int,int>>s;
    while(n--){
        cin>>h;
        while(!s.empty()&&h>s.top().first){
            s.pop();
        }
        if(!s.empty()&&h==s.top().first){
            routes+=2*s.top().second++;
        }
        else{
             s.push({h,1});
        }       
    }
    cout<<routes;
}
