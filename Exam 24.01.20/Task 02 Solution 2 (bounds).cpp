#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define all(x) x.begin(),x.end() 

int main() {
    int n, m, e, i;
    cin >> n;
    vector<int>arr(n);
    for (i = 0;i < n;++i) {
        cin >> arr[i];
    }
    cin >> m;
    while (m--) {
        cin >> e;
        if (upper_bound(all(arr), e - 1) == arr.end() ||
            *upper_bound(all(arr), e - 1) != e) {
            cout << lower_bound(all(arr), e + 1) - arr.begin();
        }
        else {
            cout << (upper_bound(all(arr), e-1) - arr.begin()) << ' ' <<
                (lower_bound(all(arr), e + 1) - arr.begin()) - 1;
        }
        cout << '\n';
    }
    return 0;
}
