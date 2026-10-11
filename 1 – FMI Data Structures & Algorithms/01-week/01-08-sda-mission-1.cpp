// https://www.hackerrank.com/contests/practice-1-sda/challenges
// SDA Mission

#include <iostream>

using namespace std;

int main() {
    int m, n;
    cin >> m >> n;

    long long sum = 0;

    int a;
    for (int i = 0; i < n; ++i) {
        cin >> a;
        sum += a;
    }

    cout << (sum >= (long long) n * m ? "yes" : "no") << endl;
    
    return 0;
}
