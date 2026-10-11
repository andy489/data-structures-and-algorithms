// https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2298

#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    unordered_map<string, int> name_tax;

    int n, m, tax;
    string name;

    cin >> n >> m;

    while(n--) {
        cin >> name >> tax;
        name_tax[name] = tax;
    }

    long sum = 0;

    while(m--) {
        cin >> name;
        sum += name_tax[name];
    }

    cout << sum;

    return 0;
}