// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, i(0);
    cin >> n;
    vector<string> data(n);
    for (; i < n; ++i) cin >> data[i];
    sort(data.begin(), data.end(), greater<string>());
    for (i = 0; i < n; ++i)
        cout << data[i];
    return 0;
}// which is the same logic as in S1
