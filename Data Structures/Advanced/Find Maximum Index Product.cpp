// github.com/andy489

#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int main(){
    int n,i;
    cin >> n;

    vector<long long>arr(n),left(n),right(n);
    stack<int>s;

    long long tot_max(0);

    for (i = 0;i < n;++i){
        cin >> arr[i];
        while (!s.empty() && arr[s.top()] <= arr[i]){
            s.pop();
        }
        if (!s.empty()){
            left[i] = s.top() + 1;
        }
        s.push(i);
    }

    while (!s.empty()) {
        s.pop();
    }

    for (i = n - 1;i >= 0;--i){
        while (!s.empty() && arr[s.top()] <= arr[i]){
            s.pop();
        }
        if (!s.empty()){
            right[i] = s.top()+1;
            tot_max = max(tot_max, left[i] * right[i]);
        }
        s.push(i);
    }

    cout << tot_max;

    return 0;
}
