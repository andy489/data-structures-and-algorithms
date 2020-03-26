// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    int q, n, i, j, x;
    cin >> q;
    while (q--){cin >> n;
        vector<int>a(n), b(n);
        for (i = 0;i < n;++i){
            for (j = 0;j < n;++j){cin >> x;
                a[i] += x; //count of balls in each container
                b[j] += x; //count of balls in each type
            }
        }
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        a==b?cout<<"Possible\n":cout<<"Impossible\n";
    }
}
