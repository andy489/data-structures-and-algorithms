// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int M, N, i(0);
    cin >> M >> N;
    vector<long long> results(N);
    long long sum(0);
    for (; i < N; ++i) {
        cin >> results[i];
        sum += results[i];
    }
    return cout << (sum >= (long long) N * M ? "yes\n" : "no\n"), 0;
}
