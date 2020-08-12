// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2298

#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    unordered_map<string, int> nameTax;

    int N, M, tax;
    string name;

    cin >> N >> M;

    while(N--) {
        cin >> name >> tax;
        nameTax[name] = tax;
    }

    long sum(0);

    while(M--) {
        cin >> name;
        sum += nameTax[name];
    }

    return cout << sum, 0;
}
