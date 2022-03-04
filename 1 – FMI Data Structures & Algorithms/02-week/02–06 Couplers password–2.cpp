#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<string> data(n);
    
    for (int i = 0; i < n; ++i) {
        cin >> data[i];
    }

    sort(data.begin(), data.end(), greater<>());

    for (int i = 0; i < n; ++i) {
        cout << data[i];
    }

    return 0;
} 
