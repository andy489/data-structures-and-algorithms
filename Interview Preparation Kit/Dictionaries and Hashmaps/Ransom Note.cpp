// github.com/andy489

#include <iostream>
#include <unordered_map>
using namespace std;

int main(){
    int n,m,i;
    cin>>n>>m;
    string s;
    unordered_map<string,int> um;
    for(i=0;i<n;++i){
        cin>>s;
        ++um[s];
    }
    for(i=0;i<m;++i){
        cin>>s;
        if(um.count(s)){
            --um[s];
            if(um[s]<0){
                cout<<"No";
                return 0;
            }
        }
        else{
            cout<<"No";
            return 0;
        }
    }
    cout<<"Yes";
    return 0;
}
