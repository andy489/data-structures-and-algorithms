// github.com/andy489

#include <iostream>
#include <vector>
#include <set>
using namespace std;

int beautifulPairs(const vector<int>& a, multiset<int>& ms, int n) {
    int bp(0);
    for(const int& el:a){
        multiset<int>::iterator it=ms.find(el);
        if(it!=ms.end()){
            ++bp;
            ms.erase(it);
        }
    }
    if(ms.size()==0){
        return bp-1;
    }
    else{
        return bp+1;
    }
}

int main(){
    int n, i, x;
    cin >> n;
    vector<int>a(n);
    multiset<int>ms;
    for (i = 0;i < n;++i) {
        cin>>a[i];
    }
    for (i = 0;i < n;++i) {
        cin >> x;
        ms.insert(x);
    }
    cout << beautifulPairs(a, ms, n);
    return 0;
}
